package ti.adam;

import net.daum.adam.publisher.AdView;
import net.daum.adam.publisher.AdView.AnimationType;
import net.daum.adam.publisher.impl.AdError;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiUIView;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;

import android.util.Log;
import android.view.View;

public class BannerAdView extends TiUIView {
	private static final String TAG = "BannerAdView";
	private AdView bannerAdView;

	private String adUnitId;
	private AnimationType adTransition = AnimationType.NONE;
	private int adRequestInterval = 12;
	int prop_top;
	int prop_left;
	int prop_right;

	public BannerAdView(TiViewProxy proxy) {
		super(proxy);
	}

	@Override
	public void processProperties(KrollDict d) {
		super.processProperties(d);

		Log.d(TAG, "process properties");

		if (d.containsKey("adUnitId")) {
			Log.d(TAG, "has adUnitId: " + d.getString("adUnitId"));
			adUnitId = d.getString("adUnitId");
		}

		if (d.containsKey("requestInterval")) {
			Log.d(TAG, "has requestInterval: " + d.getInt("requestInterval"));
			adRequestInterval = d.getInt("requestInterval");
		}

		if (d.containsKey("transition")) {
			Log.d(TAG, "has transition: " + d.getString("transition"));
			String transition = d.getString("transition");

			if (transition.equals("flipVertical")) {
				adTransition = AnimationType.FLIP_VERTICAL;
			} else if (transition.equals("flipHorizontal")) {
				adTransition = AnimationType.FLIP_HORIZONTAL;
			} else if (transition.equals("slide")) {
				adTransition = AnimationType.SLIDE;
			} else if (transition.equals("fade")) {
				adTransition = AnimationType.FADE;
			}
		}

		this.createView();
	}

	private void createView() {
		bannerAdView = new net.daum.adam.publisher.AdView(proxy.getActivity());

		bannerAdView.setClientId(adUnitId);
		bannerAdView.setRequestInterval(adRequestInterval);
		bannerAdView.setAnimationType(adTransition);

		bannerAdView
				.setOnAdFailedListener(new net.daum.adam.publisher.AdView.OnAdFailedListener() {
					@Override
					public void OnAdFailed(AdError arg0, String arg1) {
						Log.d(TAG, "OnAdFailed(): " + arg1);
						proxy.fireEvent("ad_not_received", new KrollDict());
					}
				});
		bannerAdView
				.setOnAdLoadedListener(new net.daum.adam.publisher.AdView.OnAdLoadedListener() {

					@Override
					public void OnAdLoaded() {
						Log.d(TAG, "onAdLoaded()");
						proxy.fireEvent("ad_received", new KrollDict());
					}
				});

		bannerAdView.setPadding(prop_left, prop_top, prop_right, 0);

		// Add the AdView to your view hierarchy.
		// The view will have no size until the ad is loaded.
		setNativeView(bannerAdView);

		bannerAdView.setVisibility(View.VISIBLE);
	}

	public void destroy() {
		if (bannerAdView != null) {
			Log.d(TAG, "destroy()");
			bannerAdView.destroy();
		}
	}

	public void pause() {
		if (bannerAdView != null) {
			Log.d(TAG, "pause()");
			bannerAdView.pause();
		}
	}

	public void resume() {
		if (bannerAdView != null) {
			Log.d(TAG, "resume()");
			bannerAdView.resume();
		}
	}
}