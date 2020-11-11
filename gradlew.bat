<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="@dimen/dp_230"
        android:layout_margin="@dimen/dp_15"
        app:cardCornerRadius="@dimen/dp_10"
        app:cardElevation="@dimen/dp_5">

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <TextView
                android:id="@+id/more_info_pop_item_tv"
                android:layout_width="wrap_content"
                android:layout_height="@dimen/dp_35"
                android:drawablePadding="@dimen/dp_5"
                android:gravity="center"
                android:padding="@dimen/dp_5"
                android:text="补充说明："
                android:textColor="@color/colorPrimary_deep"
                android:textSize="@dimen/sp_17" />

            <EditText
                android:id="@+id/more_info_pop_item_ed"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_above="@id/more_info_pop_item_ll"
                android:layout_below="@id/more_info_pop_item_tv"
                android:background="@null"
                android:gravity="top"
                android:hint="请输入补充说明情况..."
                android:padding="@dimen/dp_5"
                android:textColor="@color/app_color_black"
                android:textSize="@dimen/sp_15" />

            <LinearLayout
                android:id="@+id/more_info_pop_item_ll"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentRight="true"
                android:layout_alignParentBottom="true"
                android:orientation="horizontal">

                <TextView
                    android:id="@+id/more_info_pop_item_cancel"
                    android:layout_width