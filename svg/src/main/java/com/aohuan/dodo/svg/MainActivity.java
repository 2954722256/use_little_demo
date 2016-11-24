package com.aohuan.dodo.svg;

import android.os.Bundle;
import android.view.View;

import com.zhy.autolayout.AutoLayoutActivity;
import com.jrummyapps.android.widget.AnimatedSvgView;

public class MainActivity extends AutoLayoutActivity {

    private AnimatedSvgView svgView;
    private AnimatedSvgView svgView2;
    private int index = -1;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        svgView = (AnimatedSvgView) findViewById(R.id.animated_svg_view);
        svgView2 = (AnimatedSvgView) findViewById(R.id.animated_svg_view2);

        svgView.postDelayed(new Runnable() {

            @Override public void run() {
                svgView.start();
            }
        }, 500);

        svgView.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {
                if (svgView.getState() == AnimatedSvgView.STATE_FINISHED) {
                    svgView.start();
                }
            }
        });

        svgView.setOnStateChangeListener(new AnimatedSvgView.OnStateChangeListener() {

            @Override public void onStateChange(int state) {
                if (state == AnimatedSvgView.STATE_TRACE_STARTED) {
                    findViewById(R.id.btn_previous).setEnabled(false);
                    findViewById(R.id.btn_next).setEnabled(false);
                } else if (state == AnimatedSvgView.STATE_FINISHED) {
                    findViewById(R.id.btn_previous).setEnabled(index != -1);
                    findViewById(R.id.btn_next).setEnabled(true);
                    if (index == -1) index = 0; // first time
                }
            }
        });
    }

    public void onNext(View view) {
        if (++index >= SVG.values().length) index = 0;
        setSvg(SVG.values()[index]);
    }

    public void onPrevious(View view) {
        if (--index < 0) index = SVG.values().length - 1;
        setSvg(SVG.values()[index]);
    }

    private void setSvg(SVG svg) {
        svgView.setGlyphStrings(svg.glyphs);
        svgView.setFillColors(svg.colors);
        svgView.setViewportSize(svg.width, svg.height);
        svgView.setTraceResidueColor(0x32000000);
        svgView.setTraceColors(svg.colors);
        svgView.rebuildGlyphData();
        svgView.start();
    }

}