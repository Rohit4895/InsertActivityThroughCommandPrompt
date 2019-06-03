.class public Lcom/demo/MainActivity; 
.super Landroid/app/Activity; 
.source "MainActivity.java" 
 
# interfaces 
.implements Landroid/view/View$OnClickListener; 
 
 
# instance fields 
.field private drawable:I 
 
.field private editText:Landroid/widget/EditText; 
 
.field private final textAction:Ljava/lang/String; 
 
.field private txtLink:Landroid/widget/TextView; 
 
 
# direct methods 
.method public constructor <init>()V 
    .locals 1 
 
    .line 19 
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V 
 
    .line 21 
    const-string v0, "Press Me" 
 
    iput-object v0, p0, Lcom/demo/MainActivity;->textAction:Ljava/lang/String; 
 
    .line 22 
    const/4 v0, 0x0 
 
    iput-object v0, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    .line 23 
    iput-object v0, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    .line 24 
    const v0, 0x7f020093 
 
    iput v0, p0, Lcom/demo/MainActivity;->drawable:I 
 
    return-void 
.end method 
 
.method private getLayout()Landroid/view/View; 
    .locals 9 
    .annotation build Landroid/annotation/SuppressLint; 
        value = { 
            "ResourceType" 
        } 
    .end annotation 
 
    .line 35 
    new-instance v0, Landroid/widget/RelativeLayout; 
 
    invoke-direct {v0, p0}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V 
 
    .line 37 
    .local v0, "rel":Landroid/widget/RelativeLayout; 
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams; 
 
    const/4 v2, -0x2 
 
    const/16 v3, 0x190 
 
    invoke-direct {v1, v3, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V 
 
    .line 40 
    .local v1, "layoutParamsEditText":Landroid/widget/RelativeLayout$LayoutParams; 
    const/16 v3, 0xd 
 
    const/4 v4, -0x1 
 
    invoke-virtual {v1, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V 
 
    .line 41 
    new-instance v4, Landroid/widget/EditText; 
 
    invoke-direct {v4, p0}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V 
 
    iput-object v4, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    .line 42 
    iget-object v4, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    const/16 v5, 0x3ea 
 
    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setId(I)V 
 
    .line 43 
    iget-object v4, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    invoke-virtual {v4, v1}, Landroid/widget/EditText;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V 
 
    .line 44 
    iget-object v4, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    const/4 v5, 0x1 
 
    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setSingleLine(Z)V 
 
    .line 45 
    iget-object v4, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    const/4 v6, 0x6 
 
    invoke-virtual {v4, v6}, Landroid/widget/EditText;->setImeOptions(I)V 
 
    .line 46 
    iget-object v4, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V 
 
    .line 49 
    new-instance v4, Landroid/widget/RelativeLayout$LayoutParams; 
 
    invoke-direct {v4, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V 
 
    .line 52 
    .local v4, "layoutParamsButtonClass":Landroid/widget/RelativeLayout$LayoutParams; 
    iget-object v6, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    invoke-virtual {v6}, Landroid/widget/EditText;->getId()I 
 
    move-result v6 
 
    const/4 v7, 0x3 
 
    invoke-virtual {v4, v7, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V 
 
    .line 53 
    const/16 v6, 0xe 
 
    invoke-virtual {v4, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V 
 
    .line 54 
    iget v6, p0, Lcom/demo/MainActivity;->drawable:I 
 
    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V 
 
    .line 55 
    new-instance v6, Landroid/widget/Button; 
 
    invoke-direct {v6, p0}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V 
 
    .line 56 
    .local v6, "buttonAction":Landroid/widget/Button; 
    const/16 v8, 0x3e9 
 
    invoke-virtual {v6, v8}, Landroid/widget/Button;->setId(I)V 
 
    .line 57 
    const-string v8, "Press Me" 
 
    invoke-virtual {v6, v8}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V 
 
    .line 58 
    invoke-virtual {v6, v4}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V 
 
    .line 59 
    const-string v8, "Press Me" 
 
    invoke-virtual {v6, v8}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V 
 
    .line 60 
    invoke-virtual {v6, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V 
 
    .line 61 
    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V 
 
    .line 64 
    new-instance v8, Landroid/widget/RelativeLayout$LayoutParams; 
 
    invoke-direct {v8, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V 
 
    move-object v2, v8 
 
    .line 66 
    .local v2, "layoutParamsTxtLink":Landroid/widget/RelativeLayout$LayoutParams; 
    invoke-virtual {v6}, Landroid/widget/Button;->getId()I 
 
    move-result v8 
 
    invoke-virtual {v2, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V 
 
    .line 67 
    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V 
 
    .line 68 
    const/16 v3, 0x96 
 
    iput v3, v2, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I 
 
    .line 70 
    new-instance v3, Landroid/widget/TextView; 
 
    invoke-direct {v3, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V 
 
    iput-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    .line 71 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod; 
 
    move-result-object v7 
 
    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V 
 
    .line 72 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    const-string v7, "<a href=http://zocken.zone/>zocken zone</a>" 
 
    invoke-static {v7}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned; 
 
    move-result-object v7 
 
    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V 
 
    .line 73 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setLinksClickable(Z)V 
 
    .line 74 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    const/4 v5, 0x4 
 
    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setVisibility(I)V 
 
    .line 75 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    const/high16 v5, 0x41e00000    # 28.0f 
 
    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setTextSize(F)V 
 
    .line 76 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    const/high16 v5, -0x10000 
 
    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setLinkTextColor(I)V 
 
    .line 77 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    invoke-virtual {v0, v3, v2}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V 
 
    .line 79 
    return-object v0 
.end method 
 
 
# virtual methods 
.method public onClick(Landroid/view/View;)V 
    .locals 4 
    .param p1, "view"    # Landroid/view/View; 
 
    .line 86 
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object; 
 
    move-result-object v0 
 
    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String; 
 
    move-result-object v0 
 
    .line 88 
    .local v0, "value":Ljava/lang/String; 
    const-string v1, "Press Me" 
 
    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z 
 
    move-result v1 
 
    if-eqz v1, :cond_3 
 
    .line 91 
    iget-object v1, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable; 
 
    move-result-object v1 
 
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String; 
 
    move-result-object v1 
 
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z 
 
    move-result v1 
 
    const/4 v2, 0x0 
 
    if-nez v1, :cond_2 
 
    iget-object v1, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    .line 92 
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable; 
 
    move-result-object v1 
 
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String; 
 
    move-result-object v1 
 
    invoke-static {v1}, Landroid/text/TextUtils;->isDigitsOnly(Ljava/lang/CharSequence;)Z 
 
    move-result v1 
 
    if-eqz v1, :cond_2 
 
    iget-object v1, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    .line 93 
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable; 
 
    move-result-object v1 
 
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String; 
 
    move-result-object v1 
 
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I 
 
    move-result v1 
 
    const/4 v3, 0x1 
 
    if-gt v1, v3, :cond_2 
 
    iget-object v1, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    .line 94 
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable; 
 
    move-result-object v1 
 
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String; 
 
    move-result-object v1 
 
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I 
 
    move-result v1 
 
    if-gez v1, :cond_0 
 
    goto :goto_0 
 
    .line 101 
    :cond_0 
    iget-object v1, p0, Lcom/demo/MainActivity;->editText:Landroid/widget/EditText; 
 
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable; 
 
    move-result-object v1 
 
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String; 
 
    move-result-object v1 
 
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I 
 
    move-result v1 
 
    .line 103 
    .local v1, "userValue":I 
    if-nez v1, :cond_1 
 
    .line 105 
    iget-object v3, p0, Lcom/demo/MainActivity;->txtLink:Landroid/widget/TextView; 
 
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setVisibility(I)V 
 
    goto :goto_1 
 
    .line 109 
    :cond_1 
    new-instance v2, Landroid/content/Intent; 
 
    const-string v3, "com.custom.action" 
 
    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V 
 
    .line 110 
    .local v2, "intentAction":Landroid/content/Intent; 
    invoke-virtual {p0, v2}, Lcom/demo/MainActivity;->startActivity(Landroid/content/Intent;)V 
 
    goto :goto_1 
 
    .line 95 
    .end local v1    # "userValue":I 
    .end local v2    # "intentAction":Landroid/content/Intent; 
    :cond_2 
    :goto_0 
    const-string v1, "Please Enter 0 or 1" 
 
    invoke-static {p0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast; 
 
    move-result-object v1 
 
    .line 97 
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V 
 
    .line 98 
    return-void 
 
    .line 118 
    :cond_3 
    :goto_1 
    return-void 
.end method 
 
.method protected onCreate(Landroid/os/Bundle;)V 
    .locals 1 
    .param p1, "savedInstanceState"    # Landroid/os/Bundle; 
 
    .line 28 
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V 
 
    .line 29 
    invoke-direct {p0}, Lcom/demo/MainActivity;->getLayout()Landroid/view/View; 
 
    move-result-object v0 
 
    invoke-virtual {p0, v0}, Lcom/demo/MainActivity;->setContentView(Landroid/view/View;)V 
 
    .line 30 
    return-void 
.end method 
