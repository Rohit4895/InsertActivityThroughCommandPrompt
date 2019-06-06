.class public Lcom/example/retrofitresponse/Subscription;
.super Ljava/lang/Object;
.source "Subscription.java"


# instance fields
.field private valid:Z
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "valid"
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
.method public getValid()Z
    .locals 1

    .line 12
    iget-boolean v0, p0, Lcom/example/retrofitresponse/Subscription;->valid:Z

    return v0
.end method

.method public setValid(Z)V
    .locals 0
    .param p1, "valid"    # Z

    .line 16
    iput-boolean p1, p0, Lcom/example/retrofitresponse/Subscription;->valid:Z

    .line 17
    return-void
.end method
