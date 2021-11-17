package com.witchnwitcher.pocketguide.ui.home;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vk.api.sdk.utils.VKUtils;

import java.io.File;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Список гайдов");
    }

    public LiveData<String> getText() {
        return mText;
    }

    /* public void getFiles(ListView view, Activity activity) {

        File dir = new File("/storage/emulated/0/");
        File f = new File(dir.toString());
        File[] list = f.listFiles();
        int n = list.length;
        String[] fileNames = new String[n];
        for (int i = 0; i < list.length; i++)
        {
            fileNames[i] = list[i].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, fileNames);
        view.setAdapter(adapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // по позиции получаем выбранный элемент
                String selectedItem = fileNames[position];
                // установка текста элемента TextView
                Toast toast = Toast.makeText(activity, selectedItem, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void getGuides()
    {

    }*/
}