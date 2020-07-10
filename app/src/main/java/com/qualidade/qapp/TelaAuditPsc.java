package com.qualidade.qapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TelaAuditPsc extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Item_1_5Fragment item_1_5;
    private Item_6_11Fragment item_6_11;
    private Item_12_15Fragment item_12_15;
    private Item_16_18Fragment item_16_18;

    CheckBox checkBox1 = null;
    CheckBox checkBox2 = null;
    CheckBox checkBox3 = null;
    CheckBox checkBox4 = null;
    CheckBox checkBox5 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_audit_psc);
        setTitle("Auditoria PSC");

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        item_1_5 = new Item_1_5Fragment();
        item_6_11 = new Item_6_11Fragment();
        item_12_15 = new Item_12_15Fragment();
        item_16_18 = new Item_16_18Fragment();


        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(item_1_5, "Item 1-5");
        viewPagerAdapter.addFragment(item_6_11, "Item 6-11");
        viewPagerAdapter.addFragment(item_12_15, "Item 12-15");
        viewPagerAdapter.addFragment(item_16_18, "Item 15-18");

        /*viewPagerAdapter.addFragment(item_1_2, "Perso/BH/Manuseio/Agilização");
        viewPagerAdapter.addFragment(item_3_5, "Personalização");
        viewPagerAdapter.addFragment(item_6_10, "Manuseio (DC/MX/BH)");
        viewPagerAdapter.addFragment(item_11, "Bell & Howell");
        viewPagerAdapter.addFragment(item_12, "Retrabalhos (Produção)");
        viewPagerAdapter.addFragment(item_13_15, "Roterização");
        viewPagerAdapter.addFragment(item_16, "Agilização (Dupla custódia)");
        viewPagerAdapter.addFragment(item_17, "Perso/BH/Manuseio/Agilização");
        viewPagerAdapter.addFragment(item_18, "Personalização (Limpeza das máquinas)");*/
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void ativarCheckBox(View view) {
        Switch switchA = (Switch) findViewById(R.id.switchA);
        Switch switchB = (Switch) findViewById(R.id.switchB);

        if(!switchA.isChecked()) {
            ativarChecks1();
            switchB.setEnabled(false);
        }
        else if(!switchB.isChecked()) {
            ativarChecks2();
            switchA.setEnabled(false);
        }
    }

    private void ativarChecks1() {
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox1.setEnabled(true);

        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2.setEnabled(true);
    }

    private void ativarChecks2() {
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox3.setEnabled(true);

        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox4.setEnabled(true);

        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox5.setEnabled(true);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {super(fm, behavior); }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {return fragmentList.get(position); }

        @Override
        public int getCount() { return fragmentList.size(); }

        public CharSequence getPageTitle(int position) {return fragmentTitle.get(position); }
    }
}