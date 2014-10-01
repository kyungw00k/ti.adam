package ti.adam;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

@Kroll.module(name = "Adam", id = "ti.adam")
public class AdamModule extends KrollModule {

	private static final String LCAT = "AdamModule";
	private static final boolean DBG = TiConfig.LOGD;

	public AdamModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Log.d(LCAT, "inside onAppCreate");
	}
}
