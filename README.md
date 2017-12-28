# IEXTrading4j HIST: Open source IEX Trading TOPS and DEEP library

[![Build Status](https://travis-ci.org/WojciechZankowski/iextrading4j-hist.svg?branch=master)](https://travis-ci.org/WojciechZankowski/iextrading4j-hist)

## Table of Contents

* [Quick Start](#quick-start)
* [Description](#description)  
* [IEX Trading](#iex-trading)
  * [DEEP](#deep)
  * [TOPS](#tops)
* [Sample](#sample)
  * [DEEP](#deep)
  * [TOPS](#tops)
* [Roadmap](#roadmap)
* [License](#license)

## Quick Start

Java SE 8 is required to use IEXTrading4j HIST library.

```
<dependency>
	<groupId>pl.zankowski</groupId>
	<artifactId>iextrading4j-hist-all</artifactId>
	<version>1.0.0</version>
</dependency>
```

Library is up to:

* TOPS version 1.56 - May 9, 2017
* DEEP version 1.04 - August 1, 2017

## Description

IEX Trading allows users to receive their market data completly for free. Their data can be accessed in real-time during market session or can be downloaded as recorded sessions in PCAP data format. Market Data is transported in binary format and can be read according to specification shared on their site. 

This library allows you to transform binary packets into human readable Market Data events in Java.

More on this topic can found here: [IEX Trading Market Data](https://www.iextrading.com/trading/market-data/)

## IEX Trading

IEX A Fair, Simple, Transparent Exchange.

IEX is a stock exchange based in the United States. Started by Brad Katsuyama, it opened for trading on October 25, 2013. The company’s offices are located at 4 World Trade Center in New York City. The matching engine is located across the Hudson River in Weehawken, New Jersey, and the initial point of presence is located in a data center in Secaucus, New Jersey. IEX's main innovation is a 38-mile coil of optical fiber placed in front of its trading engine. This 350 microsecond delay adds a round-trip delay of 0.0007 seconds and is designed to negate the certain speed advantages utilized by some high-frequency traders.

IEX was created in response to questionable trading practices that had become widely used across traditional public Wall Street exchanges as well as dark pools and other alternative trading systems. The IEX exchange aims to attract investors by promising to "play fair" by operating in a transparent and straightforward manner, while also helping to level the playing field for traders. Strategies to achieve those goals include:

* Publishing the matching rules used in the exchanges's computerized order matching engine.
* Offering a limited number of simple and familiar order types.
* Charging fixed fees on most orders (or a flat percentage rate on small orders).
* Ensuring market pricing data arrives at external points of presence simultaneously.
* Slightly delaying market pricing data to all customers (no colocation).
* Refusing to pay for order flow.

Check out their beautiful site: [IEX Trading](https://iextrading.com/)

### DEEP

DEEP is used to receive real-time depth of book quotations direct from IEX. The depth of book quotations received via DEEP provide an aggregated size of resting displayed orders at a price and side, and do not indicate the size or number of individual orders at any price level. Non-displayed orders and non-displayed portions of reserve orders are not represented in DEEP.

DEEP also provides last trade price and size information. Trades resulting from either displayed or non-displayed orders matching on IEX will be reported. Routed executions will not be reported.

### TOPS

TOPS is used to receive real-time top of book quotations direct from IEX. The quotations received via TOPS provide an aggregated size and do not indicate the size or number of individual orders at the best bid or ask. Non-displayed orders and non-displayed portions of reserve orders are not represented in TOPS.

TOPS also provides last trade price and size information. Trades resulting from either displayed or non-displayed orders matching on IEX will be reported. Routed executions will not be reported.

## Sample

To run samples it is required to have pcap library (Npcap recommended) installed on computer.

### TOPS

```java 
private void readTOPSsample() throws PcapNativeException, InterruptedException, NotOpenException {
    PcapHandle handle = Pcaps.openOffline("path_to_pcap", PcapHandle.TimestampPrecision.NANO);

    handle.loop(-1, new PacketListener() {
        @Override
        public void gotPacket(Packet packet) {
            byte[] data = packet.getPayload().getPayload().getPayload().getRawData();
            IEXSegment block = IEXTOPSMessageBlock.createIEXSegment(data);
            System.out.println(block);
        }
    });

    handle.close();
}
```

### DEEP

```java
private void readDEEPsample() throws PcapNativeException, InterruptedException, NotOpenException {
    PcapHandle handle = Pcaps.openOffline("path_to_pcap", PcapHandle.TimestampPrecision.NANO);

    handle.loop(-1, new PacketListener() {
        @Override
        public void gotPacket(Packet packet) {
            byte[] data = packet.getPayload().getPayload().getPayload().getRawData();
            IEXSegment block = IEXDEEPMessageBlock.createIEXSegment(data);
            System.out.println(block);
        }
    });

    handle.close();
}
```

## Roadmap

* Support TOPS v1.6

## License

Code and documentation released under the Apache License, Version 2.0

Data provided for free by [IEX](https://iextrading.com/developer).

IEX Trading API Exhibit A: [Exhibit A](https://iextrading.com/api-exhibit-a)
