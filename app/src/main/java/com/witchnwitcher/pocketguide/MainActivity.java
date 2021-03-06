package com.witchnwitcher.pocketguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;
import com.vk.api.sdk.auth.VKScope;
import com.vk.api.sdk.utils.VKUtils;
import com.witchnwitcher.pocketguide.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity
{


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_account, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Если пользователь НЕ авторизован
        if (!VK.isLoggedIn())
        {
            // Запускаем процедуру авторизации
            // Создаём динамический массив с разрешениями, которые будем запрашивать у пользователя ВК
            Collection<VKScope> scopes = new ArrayList<>();
            // Добавляем в динамический массив нужные разрешения, в данном случае - к стене
            scopes.add(VKScope.WALL);
            // Непосредственно авторизация
            VK.login(this, scopes);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (VK.onActivityResult(requestCode, resultCode, data, new VKAuthCallback() {
            @Override
            public void onLogin(@NonNull VKAccessToken vkAccessToken) {
                Toast.makeText(getBaseContext(), "Авторизация прошла успешно", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoginFailed(int i) {
                Toast.makeText(getBaseContext(), "Авторизация не удалась", Toast.LENGTH_LONG).show();
            }
        }))
        {
          super.onActivityResult(requestCode, resultCode, data);
        }
    }

}