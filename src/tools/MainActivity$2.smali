.class Lcom/example/retrofitresponse/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/retrofitresponse/MainActivity;->getAlertDialog(Ljava/lang/String;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/example/retrofitresponse/MainActivity;

.field final synthetic val$message:Ljava/lang/String;

.field final synthetic val$status:Z


# direct methods
.method constructor <init>(Lcom/example/retrofitresponse/MainActivity;ZLjava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/example/retrofitresponse/MainActivity;

    .line 84
    iput-object p1, p0, Lcom/example/retrofitresponse/MainActivity$2;->this$0:Lcom/example/retrofitresponse/MainActivity;

    iput-boolean p2, p0, Lcom/example/retrofitresponse/MainActivity$2;->val$status:Z

    iput-object p3, p0, Lcom/example/retrofitresponse/MainActivity$2;->val$message:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .line 87
    iget-boolean v0, p0, Lcom/example/retrofitresponse/MainActivity$2;->val$status:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity$2;->val$message:Ljava/lang/String;

    const-string v1, "Data validated..."

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 89
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "com.custom.action"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 90
    iget-object v1, p0, Lcom/example/retrofitresponse/MainActivity$2;->this$0:Lcom/example/retrofitresponse/MainActivity;

    invoke-virtual {v1, v0}, Lcom/example/retrofitresponse/MainActivity;->startActivity(Landroid/content/Intent;)V

    .end local v0    # "intent":Landroid/content/Intent;
    goto :goto_0

    .line 91
    :cond_0
    iget-boolean v0, p0, Lcom/example/retrofitresponse/MainActivity$2;->val$status:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity$2;->val$message:Ljava/lang/String;

    const-string v1, "Invalid Data..."

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    goto :goto_1

    :cond_1
    :goto_0
    nop

    .line 96
    :goto_1
    return-void
.end method
