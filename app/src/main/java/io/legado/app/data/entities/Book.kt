package io.legado.app.data.entities

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "books", indices = [(Index(value = ["descUrl"]))])
data class Book(@PrimaryKey
                var descUrl: String = "",                   // 详情页Url(本地书源存储完整文件路径)
                var sourceId: Int = -1,                     // 书源规则id(默认-1,表示本地书籍)
                var name: String = "",                      // 书籍名称(允许用户修改,适用于本地书籍)
                var author: String? = null,                 // 作者名称(允许用户修改,适用于本地书籍)
                var tag: String? = null,                    // 分类信息(允许用户修改,适用于本地书籍)
                var coverUrl: String? = null,               // 封面Url
                var customCoverUrl: String? = null,         // 自定义封面Url(允许用户修改,适用于网络和本地书籍)
                var description: String? = null,            // 简介内容(允许用户修改,适用于网络和本地书籍)
                var charset: String? = null,                // 自定义字符集名称(仅适用于本地书籍)
                var type: Int = 0,                          // 0: 文本读物, 1: 有声读物
                var group: Int = 0,                         // 自定义分组索引号
                var tocUrl: String = "",                    // 目录页Url (toc=table of Contents)
                var latestChapterName: String? = null,      // 最新章节
                var lastCheckTime: Long? = null,            // 最近一次更新书籍信息的时间
                var hasNewChapter: Boolean = false,         // 最近一次更新书籍信息时是否发现新章节
                var latestChapterTime: Long? = null,        // 最近一次发现新章节的时间
                var latestCheckCount: Int = 0,              // 最近一次发现新章节的数量
                var totalChapterNum: Int = 0,               // 书籍目录总数
                var durChapterName: String = "",            // 当前章节名称
                var durChapterIndex: Int = 0,               // 当前章节索引
                var durChapterMark: Int = 0,                // 当前阅读的进度(首行字符的索引位置)
                var durChapterTime: Long = 0,               // 最近一次阅读书籍的时间(打开正文的时间)
                var canUpdate: Boolean = true,              // 刷新书架时更新书籍信息
                var variable: String? = null                // 自定义书籍变量信息(用于书源规则检索书籍信息)
) : Parcelable {

    fun getUnreadChapterNum() = Math.max(totalChapterNum - durChapterIndex - 1, 0)

}