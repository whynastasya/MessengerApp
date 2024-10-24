package com.example.messenagerapp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MessengerApi {
    @POST("/chat")
    suspend fun createChat(@Body chat: Chat): Response<Chat>

    @POST("/chat/add/members")
    suspend fun addMembers(@Body members: AddMembersRequest): Response<Void>

    @GET("/chat/all")
    suspend fun getAllChats(@Query("user-id") userId: Int): Response<List<Chat>>

    @GET("/chat/members/{id}")
    suspend fun getChatMembers(@Path("id") chatId: Int): Response<List<User>>

    @GET("/chat/{id}")
    suspend fun getChatById(@Path("id") chatId: Int): Response<Chat>

    @DELETE("/chat/{id}")
    suspend fun deleteChat(@Path("id") chatId: Int): Response<Void>

    @POST("/contact")
    suspend fun createContact(@Body contact: User): Response<User>

    @DELETE("/contact/{id}")
    suspend fun deleteContact(@Path("id") contactId: Int): Response<Void>

    @GET("/contact/all")
    suspend fun getAllContacts(@Query("user-id") userId: Int): Response<List<User>>

    @GET("/contact/{id}")
    suspend fun getContactById(@Path("id") contactId: Int): Response<User>

    @GET("/messenger/connect")
    suspend fun connectToMessenger(@Query("chat-id") chatId: Int): Response<Void>

    @POST("/user/refresh/{id}")
    suspend fun refreshTokens(@Path("id") userId: Int, @Body token: Token): Response<Void>

    @POST("/user/sign-in")
    suspend fun signIn(@Body credentials: Credentials): Response<AuthResponse>

    @POST("/user/sign-up")
    suspend fun signUp(@Body credentials: Credentials): Response<Void>
}