package com.ddona.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.network.adapter.NewsAdapter
import com.ddona.network.databinding.ActivityMainBinding
import com.ddona.network.model.News

class MainActivity : AppCompatActivity() {
    private val listNews = arrayListOf(
        News(
            "Tình hình dịch COVID-19 trên cả nước ngày 5/11",
            "Là một trong những doanh nhân \"quyền lực\" và có tầm ảnh hưởng trong lĩnh vực bất động sản, nhưng số dư tài khoản của",
            "https://www.24h.com.vn/bong-da/ronaldo-banh-bao-cung-sao-mu-di-nhau-bi-canh-sat-phat-thang-tay-c48a1304057.html",
            "https://image.24h.com.vn/upload/4-2021/images/2021-11-05/1636103017-767-thumbnail-width640height480.jpg",
            "Fri, 05 Nov 2021 16:08:33 +0700"
        ),
        News(
            "Tình hình dịch COVID-19 trên cả nước ngày 5/11",
            "Là một trong những doanh nhân \"quyền lực\" và có tầm ảnh hưởng trong lĩnh vực bất động sản, nhưng số dư tài khoản của",
            "https://www.24h.com.vn/bong-da/ronaldo-banh-bao-cung-sao-mu-di-nhau-bi-canh-sat-phat-thang-tay-c48a1304057.html",
            "https://image.24h.com.vn/upload/4-2021/images/2021-11-05/1636103017-767-thumbnail-width640height480.jpg",
            "Fri, 05 Nov 2021 16:08:33 +0700"
        ),
        News(
            "Tình hình dịch COVID-19 trên cả nước ngày 5/11",
            "Là một trong những doanh nhân \"quyền lực\" và có tầm ảnh hưởng trong lĩnh vực bất động sản, nhưng số dư tài khoản của",
            "https://www.24h.com.vn/bong-da/ronaldo-banh-bao-cung-sao-mu-di-nhau-bi-canh-sat-phat-thang-tay-c48a1304057.html",
            "https://image.24h.com.vn/upload/4-2021/images/2021-11-05/1636103017-767-thumbnail-width640height480.jpg",
            "Fri, 05 Nov 2021 16:08:33 +0700"
        )
    )
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = NewsAdapter(listNews)
        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}