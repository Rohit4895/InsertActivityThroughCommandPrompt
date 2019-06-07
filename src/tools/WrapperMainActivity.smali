.class public Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;
.super Landroid/app/Activity;
.source "WrapperMainActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field private drawable:I

.field private message:Ljava/lang/String;

.field private progressBar:Landroid/widget/ProgressBar;

.field private status:Z

.field private final textAction:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 17
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 19
    const v0, 0x7f060055

    iput v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->drawable:I

    .line 20
    const-string v0, "fetch Data"

    iput-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->textAction:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;)Landroid/widget/ProgressBar;
    .locals 1
    .param p0, "x0"    # Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;

    .line 17
    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->progressBar:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$100(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;Ljava/lang/String;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Z

    .line 17
    invoke-direct {p0, p1, p2}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->getAlertDialog(Ljava/lang/String;Z)V

    return-void
.end method

.method private getAlertDialog(Ljava/lang/String;Z)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "status"    # Z

    .line 101
    iput-object p1, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->message:Ljava/lang/String;

    .line 102
    iput-boolean p2, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->status:Z

    .line 103
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 104
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 105
    const-string v1, "OK"

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 106
    const-string v1, "Cancel"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 108
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    .line 109
    .local v1, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 111
    return-void
.end method

.method private getLayout()Landroid/view/View;
    .locals 5

    .line 81
    new-instance v0, Landroid/widget/RelativeLayout;

    invoke-direct {v0, p0}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 83
    .local v0, "rel":Landroid/widget/RelativeLayout;
    iget v1, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->drawable:I

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 85
    new-instance v1, Landroid/widget/ProgressBar;

    invoke-virtual {p0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->progressBar:Landroid/widget/ProgressBar;

    .line 86
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x2

    invoke-direct {v1, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 90
    .local v1, "lpForProgressBar":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v2, 0xd

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 91
    iget-object v3, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v3, v1}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 92
    iget-object v3, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->progressBar:Landroid/widget/ProgressBar;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/ProgressBar;->setIndeterminate(Z)V

    .line 93
    iget-object v3, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v3, v2}, Landroid/widget/ProgressBar;->setForegroundGravity(I)V

    .line 94
    iget-object v2, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->progressBar:Landroid/widget/ProgressBar;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 95
    iget-object v2, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 97
    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .line 115
    iget-boolean v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->status:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->message:Ljava/lang/String;

    const-string v1, "Data validated..."

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 116
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 117
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "com.custom.action"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 118
    invoke-virtual {p0, v0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->startActivity(Landroid/content/Intent;)V

    .end local v0    # "intent":Landroid/content/Intent;
    goto :goto_0

    .line 119
    :cond_0
    iget-boolean v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->status:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->message:Ljava/lang/String;

    const-string v1, "Invalid Data..."

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    goto :goto_1

    :cond_1
    :goto_0
    nop

    .line 124
    :goto_1
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 27
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    invoke-direct {p0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->getLayout()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;->setContentView(Landroid/view/View;)V

    .line 30
    new-instance v0, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;

    invoke-direct {v0, p0}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;-><init>(Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 74
    invoke-virtual {v0, v1}, Lcom/example/restapicallingwithoutretrofit/WrapperMainActivity$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 76
    return-void
.end method
