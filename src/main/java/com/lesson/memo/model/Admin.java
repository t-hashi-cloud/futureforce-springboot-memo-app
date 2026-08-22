package com.lesson.memo.model;//パッケージ宣言

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// IDは自動的に増加
    private Long id;
    
    @NotBlank(message = "姓を入力してください")
    @Column(nullable = false, length = 255)//空白NG、最大桁数（文字数）を255に指定
    private String lastName;//Javaの命名規則に従う
    
    @NotBlank(message = "名を入力してください")
    @Column(nullable = false, length = 255)//空白NG、最大桁数（文字数）を255に指定
    private String firstName;

    @NotBlank(message = "メールアドレスを入力してください")
    @Column(nullable = false, length = 255, unique = true)//空白NG、最大桁数（文字数）を255に指定、UNIQUE 制約（他のレコードと値が重複することを許可しない）
    private String email;
    
    @NotBlank(message = "パスワードを入力してください")
    @Column(nullable = false, length = 255)//空白NG、最大桁数（文字数）を255に指定、service層等でPasswordEncoderによりハッシュ化した文字列を保持する
    private String password;

    @Column(name = "created_at", 
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", 
        insertable = false, 
        updatable = false)
    private LocalDateTime createdAt;
    //DBのカラム名をcreated_atに指定
    //自動で"今の時間"を入れて
    //何も入れない
    //更新しない

    @Column(name = "updated_at", 
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", 
        insertable = false, 
        updatable = false)
    //DBのカラム名をupdated_atに指定
    //新規作成時・更新時、両方でDBが自動的に現在時刻をセット
    //アプリ(Hibernate)からはUPDATE文で書き込まない
    //UPDATE文にもこのカラムを含めない（DB任せにする）
    private LocalDateTime updatedAt;
  
}
