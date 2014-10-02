# adam Module

## Description

Ad@m Mobile Ad App SDK for Titanium

## Accessing the adam Module

To access this module from JavaScript, you would do the following:

    var adam = require("ti.adam");

The adam variable is a reference to the Module object.

## Adam for Publishers Developer Docs

See [Ad@m Android Publisher SDK Guide](https://github.com/mobilead/mobilead-android-sdk/blob/master/GUIDE.md)

## Functions

### createBannerAdView({...})

Returns a view with an ad initialized by default.

#### Arguments

| key | value | description |
| --- | ----- | ----------- |
| adUnitId `required` | `Your Ad Unit Id` | Ad Unit ID |
| requestInterval `optional` |  12 ~ 120 |  default : `60` seconds, min : `12`, max : `120` |
| transition `optional` | One of `none`(default), `flipVertical`, `flipHorizontal`, `slide`, `fade`| Ad switching animation. |

## Example

    var win = Ti.UI.createWindow({
      backgroundColor:'black'
    });

    var adam = require('ti.adam');

    Ti.API.info(adam);

    if (Ti.Platform.name == "android") {
      var banner = adam.createBannerAdView({
        //
        // AD UNIT ID
        //
        adUnitId : 'TestClientId',

        //
        // ad request interval
        // value : default 60s (min : 12s, max : 120s)
        //
        requestInterval : 60,

        //
        // animation when ad is switching to another
        // value : none, flipVertical, flipHorizontal, slide, fade
        //
        transition : 'fade'
      });

      Ti.API.info(banner);

      //
      // callback when ad has received
      //
      banner.addEventListener("ad_received", function(){
        Ti.API.info("ad received");
      });

      //
      // callback when ad has not received
      //
      banner.addEventListener("ad_not_received", function(){
          Ti.API.info("ad not received");
      });

      win.add(banner);
    }

    win.open();

## Alloy Example
.xml

    <BannerAdView id="adamBanner" module="ti.adam"></BannerAdView>

.tss

    "#adamBanner" : {
    	adUnitId : 'TestClientId',
	    requestInterval : 60, 
	    transition : 'fade',
	    top : 0
    }
