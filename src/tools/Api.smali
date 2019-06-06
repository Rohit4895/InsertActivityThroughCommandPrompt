.class public Lcom/example/retrofitresponse/Api;
.super Ljava/lang/Object;
.source "Api.java"


# static fields
.field private static retrofit:Lretrofit2/Retrofit;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getClient()Lcom/example/retrofitresponse/ApiInterface;
    .locals 2

    .line 10
    sget-object v0, Lcom/example/retrofitresponse/Api;->retrofit:Lretrofit2/Retrofit;

    if-nez v0, :cond_0

    .line 11
    new-instance v0, Lretrofit2/Retrofit$Builder;

    invoke-direct {v0}, Lretrofit2/Retrofit$Builder;-><init>()V

    .line 12
    const-string v1, "http://demo5248544.mockable.io/"

    invoke-virtual {v0, v1}, Lretrofit2/Retrofit$Builder;->baseUrl(Ljava/lang/String;)Lretrofit2/Retrofit$Builder;

    move-result-object v0

    .line 13
    invoke-static {}, Lretrofit2/converter/gson/GsonConverterFactory;->create()Lretrofit2/converter/gson/GsonConverterFactory;

    move-result-object v1

    invoke-virtual {v0, v1}, Lretrofit2/Retrofit$Builder;->addConverterFactory(Lretrofit2/Converter$Factory;)Lretrofit2/Retrofit$Builder;

    move-result-object v0

    .line 14
    invoke-virtual {v0}, Lretrofit2/Retrofit$Builder;->build()Lretrofit2/Retrofit;

    move-result-object v0

    sput-object v0, Lcom/example/retrofitresponse/Api;->retrofit:Lretrofit2/Retrofit;

    .line 16
    :cond_0
    sget-object v0, Lcom/example/retrofitresponse/Api;->retrofit:Lretrofit2/Retrofit;

    const-class v1, Lcom/example/retrofitresponse/ApiInterface;

    invoke-virtual {v0, v1}, Lretrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/example/retrofitresponse/ApiInterface;

    .line 17
    .local v0, "apiInterface":Lcom/example/retrofitresponse/ApiInterface;
    return-object v0
.end method
