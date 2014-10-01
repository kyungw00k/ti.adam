// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel();
win.add(label);
win.open();

var adam = require('ti.adam');

if (Ti.Platform.name == "android") {
	var proxy = adam.createBannerAdView({
		adUnitId : 'TestClientId',
		requestInterval : 12,
		transition : 'fade' // none, flipVertical, flipHorizontal, slide, fade
	});
	win.add(proxy);
}