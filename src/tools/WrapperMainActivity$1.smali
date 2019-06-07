.class Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;
.super Landroid/os/AsyncTask;
.source "WrapperMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;


# direct methods
.method constructor <init>(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    .line 30
    iput-object p1, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 30
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 1
    .param p1, "voids"    # [Ljava/lang/Void;

    .line 34
    const-string v0, "http://demo5248544.mockable.io/getallusers"

    invoke-static {v0}, Lcom/example/restapicallingwithoutretrofit/HttpManager;->getData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .line 30
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 6
    .param p1, "status"    # Ljava/lang/String;

    .line 40
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 41
    const-string v0, "fail"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    const-string v1, "Error: "

    const/4 v2, 0x0

    const/4 v3, 0x4

    const-string v4, "demo"

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    invoke-static {v0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->access$000(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 44
    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    const-string v3, "Failed Response...\nSomething went wrong..."

    invoke-static {v0, v3, v2}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->access$100(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;Ljava/lang/String;Z)V

    .line 46
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 49
    :cond_0
    const-string v0, "exception"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    invoke-static {v0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->access$000(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 51
    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    const-string v1, "Exception Occurred..."

    invoke-static {v0, v1, v2}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->access$100(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;Ljava/lang/String;Z)V

    .line 52
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Exception: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 54
    :cond_1
    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    invoke-static {v0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->access$000(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 57
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 59
    .local v0, "jsonObject":Lorg/json/JSONObject;
    const-string v2, "subscription"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "valid"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 60
    .local v2, "validStatus":Z
    if-eqz v2, :cond_2

    .line 61
    iget-object v3, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    const-string v5, "Data validated..."

    invoke-static {v3, v5, v2}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->access$100(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;Ljava/lang/String;Z)V

    goto :goto_0

    .line 63
    :cond_2
    iget-object v3, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->this$0:Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    const-string v5, "Invalid Data..."

    invoke-static {v3, v5, v2}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->access$100(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;Ljava/lang/String;Z)V

    .line 65
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "status: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    nop

    .end local v0    # "jsonObject":Lorg/json/JSONObject;
    .end local v2    # "validStatus":Z
    goto :goto_1

    .line 66
    :catch_0
    move-exception v0

    .line 67
    .local v0, "e":Lorg/json/JSONException;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 73
    .end local v0    # "e":Lorg/json/JSONException;
    :goto_1
    return-void
.end method
