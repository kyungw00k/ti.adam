package ti.adam;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiConfig;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

@Kroll.proxy(creatableInModule = AdamModule.class)
public class BannerAdViewProxy extends TiViewProxy implements OnLifecycleEvent {
	private BannerAdView adView;

	// Standard Debugging variables
	private static final String LCAT = "BannerAdViewProxy";
	private static final boolean DBG = TiConfig.LOGD;

	// Constructor
	public BannerAdViewProxy() {
		super();
	}

	@Override
	public TiUIView createView(Activity activity) {
		adView = new BannerAdView(this);
		return adView;
	}

	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
	}

	@Override
	public void onDestroy(Activity arg0) {
		adView.destroy();
	}

	@Override
	public void onPause(Activity arg0) {
		adView.pause();

	}

	@Override
	public void onResume(Activity arg0) {
		adView.resume();

	}

	@Override
	public void onStart(Activity arg0) {
	}

	@Override
	public void onStop(Activity arg0) {
	}
}