
package org.holoeverywhere.demo;


import org.holoeverywhere.addon.AddonSlider;
import org.holoeverywhere.addon.Addons;
import org.holoeverywhere.app.Activity;
import org.holoeverywhere.demo.fragments.MainFragment;
import org.holoeverywhere.demo.fragments.OtherFragment;
import org.holoeverywhere.demo.fragments.PagesFragment;
import org.holoeverywhere.demo.fragments.SettingsFragment;
import org.holoeverywhere.demo.fragments.about.AboutFragment;
import org.holoeverywhere.demo.widget.DemoThemePicker;
import org.holoeverywhere.slider.SliderMenu;

import android.os.Bundle;

@Addons(AddonSlider.class)
public class DemoActivity extends Activity {
    public AddonSlider.AddonSliderA addonSlider() {
        return addon(AddonSlider.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SliderMenu sliderMenu = addonSlider().obtainDefaultSliderMenu(R.layout.menu);

        sliderMenu.add(R.string.demo, MainFragment.class, SliderMenu.BLUE);
        sliderMenu.add(R.string.settings, SettingsFragment.class, SliderMenu.GREEN);
        sliderMenu.add(R.string.other, OtherFragment.class, SliderMenu.ORANGE);
        sliderMenu.add(R.string.about, AboutFragment.class, SliderMenu.PURPLE);
        sliderMenu.add("Pages", PagesFragment.class, SliderMenu.PURPLE);
        
        getSupportActionBar().setTitle(R.string.library_name);

        // We are should provide activity to ThemePicker
        ((DemoThemePicker) findViewById(R.id.themePicker)).setActivity(this);
        
        
    }
}
