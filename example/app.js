var win = Ti.UI.createWindow({
	backgroundColor:'black'
});

var adam = require('ti.adam');

Ti.API.info(adam);

if (Ti.Platform.name == "android") {
	var banner = adam.createBannerAdView({
		adUnitId : 'TestClientId',
		requestInterval : 60, // default 60s (min : 12s, max : 120s)
		transition : 'fade' // none, flipVertical, flipHorizontal, slide, fade
	});

	Ti.API.info(banner);

	//
	// callback for ad received 
	//
	banner.addEventListener("ad_received", function(){
	    Ti.API.info("ad received");
	});

	banner.addEventListener("ad_not_received", function(){
	    Ti.API.info("ad not received");
	});


	win.add(banner);
}

win.open();