package com.github.mvapp2sd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by EternalPhane on 2015/6/13.
 * GitHub: https://github.com/EternalPhane
 */
public class MyAdapter extends BaseAdapter {
    private List<MyAppInfo> AppInfoList;
    LayoutInflater inflater=null;

    public MyAdapter(Context context,List<MyAppInfo> appInfoList){
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        AppInfoList=appInfoList;
    }

    @Override
    public int getCount() {
        return AppInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return AppInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        ViewHolder holder=null;
        if(convertView==null||convertView.getTag()==null){
            view=inflater.inflate(R.layout.my_listitem,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }
        else{
            view=convertView;
            holder=(ViewHolder)convertView.getTag();
        }
        MyAppInfo appInfo=(MyAppInfo)getItem(position);
        holder.Icon.setImageDrawable(appInfo.GetIcon());
        holder.AppName.setText(appInfo.GetAppName());
        holder.PackageName.setText(appInfo.GetPackageName());
        return view;
    }

    class ViewHolder{
        ImageView Icon;
        TextView AppName;
        TextView PackageName;

        public ViewHolder(View view){
            this.Icon=(ImageView)view.findViewById(R.id.item_icon);
            this.AppName=(TextView)view.findViewById(R.id.item_app_name);
            this.PackageName=(TextView)view.findViewById(R.id.item_package_name);
        }
    }
}