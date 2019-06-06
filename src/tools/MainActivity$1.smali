.class Lcom/example/retrofitresponse/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Lretrofit2/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/retrofitresponse/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lretrofit2/Callback<",
        "Lcom/example/retrofitresponse/Response;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/example/retrofitresponse/MainActivity;


# direct methods
.method constructor <init>(Lcom/example/retrofitresponse/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/example/retrofitresponse/MainActivity;

    .line 29
    iput-object p1, p0, Lcom/example/retrofitresponse/MainActivity$1;->this$0:Lcom/example/retrofitresponse/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lretrofit2/Call;Ljava/lang/Throwable;)V
    .locals 3
    .param p2, "t"    # Ljava/lang/Throwable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call<",
            "Lcom/example/retrofitresponse/Response;",
            ">;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .line 42
    .local p1, "call":Lretrofit2/Call;, "Lretrofit2/Call<Lcom/example/retrofitresponse/Response;>;"
    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity$1;->this$0:Lcom/example/retrofitresponse/MainActivity;

    invoke-static {v0}, Lcom/example/retrofitresponse/MainActivity;->access$000(Lcom/example/retrofitresponse/MainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 43
    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity$1;->this$0:Lcom/example/retrofitresponse/MainActivity;

    const-string v1, "Failed Response...\nSomething went wrong..."

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/example/retrofitresponse/MainActivity;->access$100(Lcom/example/retrofitresponse/MainActivity;Ljava/lang/String;Z)V

    .line 45
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Error: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "demo"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    return-void
.end method

.method public onResponse(Lretrofit2/Call;Lretrofit2/Response;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call<",
            "Lcom/example/retrofitresponse/Response;",
            ">;",
            "Lretrofit2/Response<",
            "Lcom/example/retrofitresponse/Response;",
            ">;)V"
        }
    .end annotation

    .line 32
    .local p1, "call":Lretrofit2/Call;, "Lretrofit2/Call<Lcom/example/retrofitresponse/Response;>;"
    .local p2, "response":Lretrofit2/Response;, "Lretrofit2/Response<Lcom/example/retrofitresponse/Response;>;"
    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity$1;->this$0:Lcom/example/retrofitresponse/MainActivity;

    invoke-static {v0}, Lcom/example/retrofitresponse/MainActivity;->access$000(Lcom/example/retrofitresponse/MainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 33
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/example/retrofitresponse/Response;

    invoke-virtual {v0}, Lcom/example/retrofitresponse/Response;->getSubscription()Lcom/example/retrofitresponse/Subscription;

    move-result-object v0

    invoke-virtual {v0}, Lcom/example/retrofitresponse/Subscription;->getValid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity$1;->this$0:Lcom/example/retrofitresponse/MainActivity;

    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/example/retrofitresponse/Response;

    invoke-virtual {v1}, Lcom/example/retrofitresponse/Response;->getSubscription()Lcom/example/retrofitresponse/Subscription;

    move-result-object v1

    invoke-virtual {v1}, Lcom/example/retrofitresponse/Subscription;->getValid()Z

    move-result v1

    const-string v2, "Data validated..."

    invoke-static {v0, v2, v1}, Lcom/example/retrofitresponse/MainActivity;->access$100(Lcom/example/retrofitresponse/MainActivity;Ljava/lang/String;Z)V

    goto :goto_0

    .line 36
    :cond_0
    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity$1;->this$0:Lcom/example/retrofitresponse/MainActivity;

    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/example/retrofitresponse/Response;

    invoke-virtual {v1}, Lcom/example/retrofitresponse/Response;->getSubscription()Lcom/example/retrofitresponse/Subscription;

    move-result-object v1

    invoke-virtual {v1}, Lcom/example/retrofitresponse/Subscription;->getValid()Z

    move-result v1

    const-string v2, "Invalid Data..."

    invoke-static {v0, v2, v1}, Lcom/example/retrofitresponse/MainActivity;->access$100(Lcom/example/retrofitresponse/MainActivity;Ljava/lang/String;Z)V

    .line 38
    :goto_0
    return-void
.end method
