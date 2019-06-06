.class public Lcom/example/retrofitresponse/MainActivity;
.super Landroid/app/Activity;
.source "MainActivity.java"


# instance fields
.field private drawable:I

.field private fetchUsers:Landroid/widget/Button;

.field private progressBar:Landroid/widget/ProgressBar;

.field private final textAction:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 17
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 19
    const v0, 0x7f060055

    iput v0, p0, Lcom/example/retrofitresponse/MainActivity;->drawable:I

    .line 20
    const-string v0, "fetch Data"

    iput-object v0, p0, Lcom/example/retrofitresponse/MainActivity;->textAction:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Lcom/example/retrofitresponse/MainActivity;)Landroid/widget/ProgressBar;
    .locals 1
    .param p0, "x0"    # Lcom/example/retrofitresponse/MainActivity;

    .line 17
    iget-object v0, p0, Lcom/example/retrofitresponse/MainActivity;->progressBar:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$100(Lcom/example/retrofitresponse/MainActivity;Ljava/lang/String;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/example/retrofitresponse/MainActivity;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Z

    .line 17
    invoke-direct {p0, p1, p2}, Lcom/example/retrofitresponse/MainActivity;->getAlertDialog(Ljava/lang/String;Z)V

    return-void
.end method

.method private getAlertDialog(Ljava/lang/String;Z)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "status"    # Z

    .line 82
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 83
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    new-instance v1, Lcom/example/retrofitresponse/MainActivity$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/example/retrofitresponse/MainActivity$2;-><init>(Lcom/example/retrofitresponse/MainActivity;ZLjava/lang/String;)V

    .line 84
    const-string v2, "OK"

    invoke-virtual {v0, v2, v1}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 98
    const-string v1, "Cancel"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 100
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    .line 101
    .local v1, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 103
    return-void
.end method

.method private getLayout()Landroid/view/View;
    .locals 5

    .line 53
    new-instance v0, Landroid/widget/RelativeLayout;

    invoke-direct {v0, p0}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 55
    .local v0, "rel":Landroid/widget/RelativeLayout;
    iget v1, p0, Lcom/example/retrofitresponse/MainActivity;->drawable:I

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 65
    new-instance v1, Landroid/widget/ProgressBar;

    invoke-virtual {p0}, Lcom/example/retrofitresponse/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/example/retrofitresponse/MainActivity;->progressBar:Landroid/widget/ProgressBar;

    .line 66
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x2

    invoke-direct {v1, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 70
    .local v1, "lpForProgressBar":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v2, 0xd

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 71
    iget-object v3, p0, Lcom/example/retrofitresponse/MainActivity;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v3, v1}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 72
    iget-object v3, p0, Lcom/example/retrofitresponse/MainActivity;->progressBar:Landroid/widget/ProgressBar;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/ProgressBar;->setIndeterminate(Z)V

    .line 73
    iget-object v3, p0, Lcom/example/retrofitresponse/MainActivity;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v3, v2}, Landroid/widget/ProgressBar;->setForegroundGravity(I)V

    .line 74
    iget-object v2, p0, Lcom/example/retrofitresponse/MainActivity;->progressBar:Landroid/widget/ProgressBar;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 75
    iget-object v2, p0, Lcom/example/retrofitresponse/MainActivity;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 77
    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 26
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    invoke-direct {p0}, Lcom/example/retrofitresponse/MainActivity;->getLayout()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/example/retrofitresponse/MainActivity;->setContentView(Landroid/view/View;)V

    .line 29
    invoke-static {}, Lcom/example/retrofitresponse/Api;->getClient()Lcom/example/retrofitresponse/ApiInterface;

    move-result-object v0

    invoke-interface {v0}, Lcom/example/retrofitresponse/ApiInterface;->getAllUsers()Lretrofit2/Call;

    move-result-object v0

    new-instance v1, Lcom/example/retrofitresponse/MainActivity$1;

    invoke-direct {v1, p0}, Lcom/example/retrofitresponse/MainActivity$1;-><init>(Lcom/example/retrofitresponse/MainActivity;)V

    invoke-interface {v0, v1}, Lretrofit2/Call;->enqueue(Lretrofit2/Callback;)V

    .line 49
    return-void
.end method
