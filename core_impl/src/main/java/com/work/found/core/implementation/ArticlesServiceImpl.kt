package com.work.found.core.implementation

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.services.ArticlesServiceInput
import java.io.InputStreamReader
import javax.inject.Inject

class ArticlesServiceImpl @Inject constructor(): ArticlesServiceInput {

    companion object {
        private const val UTF_8 = "UTF-8"
    }

    override fun loadArticles(context: Context, articlesAssetName : String): List<ArticlesItem> {
        val gson = Gson()
        val inputStream = context.assets.open(articlesAssetName)
        val jsonReader = InputStreamReader(inputStream, UTF_8)
        val licensesListType = object : TypeToken<List<ArticlesItem>>() {}.type

        return gson.fromJson(jsonReader, licensesListType)
    }
}