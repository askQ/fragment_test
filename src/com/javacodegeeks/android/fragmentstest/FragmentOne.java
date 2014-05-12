package com.javacodegeeks.android.fragmentstest;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
	   String[] titles = new String[] { "First", "Second"};

       List x = new ArrayList(); 
       List y = new ArrayList();

       x.add(new double[] { 1, 3, 5, 7, 9, 11} ); 
       x.add(new double[] { 0, 2, 4, 6, 8, 10} );

       y.add(new double[] { 3, 14, 5, 30, 20, 25}); 
       y.add(new double[] { 18, 9, 21, 15, 10, 6});

       XYMultipleSeriesDataset dataset = buildDataset(titles, x, y);

       int[] colors = new int[] { Color.BLUE, Color.GREEN};
       PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE, PointStyle.TRIANGLE}; 
      
       XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles, false);

       setChartSettings(renderer, "Line Chart Demo", "X", "Y", -1, 12, 0, 35 , Color.WHITE, Color.WHITE);

//       View chart = ChartFactory.getLineChartView(this, dataset, renderer);  //??
       
       
       
       
       double[] values = new double[] { 12, 14, 11, 10, 19 };
       int[] color = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN };

       DefaultRenderer  defaultRenderer =buildCategoryRenderer(color);
       CategorySeries  categorySeries =buildCategoryDataset("?", values);
       
	    View pie =ChartFactory.getPieChartView(getActivity(), categorySeries, defaultRenderer);  //??
       
        return pie;
       //Inflate the layout for this fragment   return inflater.inflate(R.layout.fragment_one, container, false);
   }
   
   
   protected DefaultRenderer buildCategoryRenderer(int[] colors) {
       DefaultRenderer renderer = new DefaultRenderer();
       renderer.setLabelsTextSize(15);
       renderer.setLegendTextSize(15);
       renderer.setMargins(new int[] { 20, 30, 15, 10 });
       for (int color : colors) {
         SimpleSeriesRenderer r = new SimpleSeriesRenderer();
         r.setColor(color);
         renderer.addSeriesRenderer(r);
       }
       return renderer;
     }
   
   protected CategorySeries buildCategoryDataset(String title, double[] values) {
       CategorySeries series = new CategorySeries(title);
       int k = 0;
       for (double value : values) {
         series.add("Project " + ++k, value);
       }

       return series;
     }

  

   protected XYMultipleSeriesDataset buildDataset(String[] titles, 
                                                  List xValues, 
                                                  List yValues) 
   { 
       XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

       int length = titles.length;                  //有几条线  
        for (int i = 0; i < length; i++) 
       { 
           XYSeries series = new XYSeries(titles[i]);    //根据每条线的名称创建 
             double[] xV = (double[]) xValues.get(i);                 //获取第i条线的数据 
             double[] yV = (double[]) yValues.get(i); 
           int seriesLength = xV.length;                 //有几个点

             for (int k = 0; k < seriesLength; k++)        //每条线里有几个点 
             { 
               series.add(xV[k], yV[k]); 
           }

           dataset.addSeries(series); 
       }

       return dataset; 
   }
   

   protected XYMultipleSeriesRenderer buildRenderer(int[] colors, PointStyle[] styles, boolean fill) 
   { 
       XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer(); 
       int length = colors.length; 
       for (int i = 0; i < length; i++) 
       { 
           XYSeriesRenderer r = new XYSeriesRenderer(); 
          
           r.setColor(colors[i]); 
           r.setLineWidth(3);
           r.setPointStyle(styles[i]); 
           r.setFillPoints(fill); 
           renderer.addSeriesRenderer(r); 
       } 
       return renderer; 
   }

   protected void setChartSettings(XYMultipleSeriesRenderer renderer, String title, 
                               String xTitle,String yTitle, double xMin, 
                               double xMax, double yMin, double yMax, 
                               int axesColor,int labelsColor) 
   { 
       renderer.setChartTitle(title); 
       renderer.setXTitle(xTitle); 
       renderer.setYTitle(yTitle); 
       renderer.setXAxisMin(xMin); 
       renderer.setXAxisMax(xMax); 
       renderer.setYAxisMin(yMin); 
       renderer.setYAxisMax(yMax); 
       renderer.setAxesColor(axesColor); 
       renderer.setLabelsColor(labelsColor); 
   } 
   
}
