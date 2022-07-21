package com.plcoding.ktorclientandroid.data.repository

import com.plcoding.ktorclientandroid.data.remote.PostsApi
import com.plcoding.ktorclientandroid.data.remote.dto.PostRequest
import com.plcoding.ktorclientandroid.data.remote.dto.PostResponse
import com.plcoding.ktorclientandroid.domain.repository.PostsRepository
import javax.inject.Inject

class PostsRepositoryImp @Inject constructor(
    private val api: PostsApi
) : PostsRepository {

    override suspend fun getPosts(): List<PostResponse> {
        return api.getPosts()
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return api.createPost(postRequest)
    }
}