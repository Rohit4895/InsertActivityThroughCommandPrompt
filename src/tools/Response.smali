.class public Lcom/example/retrofitresponse/Response;
.super Ljava/lang/Object;
.source "Response.java"


# instance fields
.field private subscription:Lcom/example/retrofitresponse/Subscription;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "subscription"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSubscription()Lcom/example/retrofitresponse/Subscription;
    .locals 1

    .line 13
    iget-object v0, p0, Lcom/example/retrofitresponse/Response;->subscription:Lcom/example/retrofitresponse/Subscription;

    return-object v0
.end method

.method public setSubscription(Lcom/example/retrofitresponse/Subscription;)V
    .locals 0
    .param p1, "subscription"    # Lcom/example/retrofitresponse/Subscription;

    .line 17
    iput-object p1, p0, Lcom/example/retrofitresponse/Response;->subscription:Lcom/example/retrofitresponse/Subscription;

    .line 18
    return-void
.end method
