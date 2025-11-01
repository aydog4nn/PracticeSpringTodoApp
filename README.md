# 🧩 PracticeSpringTodoApp

**Spring Boot (Backend)** ve **React (Frontend)** teknolojileriyle geliştirilmiş tam yığın (Full-Stack) bir **Yapılacaklar (Todo) Uygulaması**.  
Bu proje, modern bir full-stack uygulamanın tek depoda (monorepo) nasıl yapılandırılacağını, nasıl geliştirilip yönetileceğini gösterir.

---

## ⚙️ Proje Yapısı

```
SpringPracticeTodoApp/
│
├── practice-for-spring/     # Backend - Spring Boot 3.x
│   ├── src/main/java/...
│   ├── pom.xml
│   └── application.properties
│
├── cursorfront/             # Frontend - React
│   ├── todoapp/
│   │   ├── src/
│   │   ├── package.json
│   │   └── public/
│   └── ...
│
└── README.md
```

---

## 🚀 Özellikler

### 🔹 Backend (Spring Boot)
- RESTful API mimarisi  
- CRUD (Create, Read, Update, Delete) işlemleri  
- **Spring Data JPA** ile veritabanı yönetimi  
- **H2 Database** ile gömülü veritabanı (test ve lokal kullanım için)  
- **Lombok** ile sade kod yapısı  
- **CORS** yapılandırması (React istemcisine izin verir)

### 🔹 Frontend (React)
- Modern **React 18+** yapısı  
- Fonksiyonel bileşenler ve Hook yapısı  
- **Axios** ile API istekleri  
- Basit, duyarlı (responsive) arayüz  
- Todo listesi ekleme, silme, düzenleme işlemleri

---

## 🧰 Kullanılan Teknolojiler

| Katman | Teknolojiler |
|--------|---------------|
| **Backend** | Java 21, Spring Boot, JPA, H2, Lombok |
| **Frontend** | React, JavaScript (ES6+), Axios |
| **Build Araçları** | Maven, npm |
| **Versiyon Kontrol** | Git + GitHub |
| **IDE** | IntelliJ IDEA / VS Code |

---

## 🔗 API Uç Noktaları

| Metod | Uç Nokta | Açıklama |
|-------|-----------|-----------|
| `GET` | `/api/notes` | Tüm notları getirir |
| `POST` | `/api/notes` | Yeni not ekler |
| `GET` | `/api/notes/{id}` | ID’ye göre not getirir |
| `DELETE` | `/api/notes/{id}` | Notu siler |
| `PUT` | `/api/notes/{id}` | Notu günceller |

Örnek JSON isteği:
```json
{
  "title": "Linked-List *",
  "description": "Linked-List algoritmasini öğren.",
  "dueDate": "2025-11-01"
}
```

---

## 💻 Kurulum ve Çalıştırma

### 1️⃣ Depoyu klonla
```bash
git clone https://github.com/aydog4nn/PracticeSpringTodoApp.git
cd PracticeSpringTodoApp
```

### 2️⃣ Backend’i başlat
```bash
cd practice-for-spring
mvn spring-boot:run
```
Sunucu: `http://localhost:8080`

### 3️⃣ Frontend’i başlat
```bash
cd ../cursorfront/todoapp
npm install
npm run dev
```
Uygulama: `http://localhost:3000`

> ⚠️ API isteklerinin çalışması için backend ve frontend aynı anda açık olmalı.

---

## 🔒 CORS Yapılandırması (Spring Boot)

Backend tarafında React istemcisine izin verilmesi için aşağıdaki yapı kullanılmıştır:

```java
@Configuration
public class CorsConfig {
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*");
      }
    };
  }
}
```

---

## 🧱 Üretim (Production) Derlemesi

### 🔸 Frontend
```bash
cd cursorfront/todoapp
npm run build
```
Oluşan build çıktısı `/dist` veya `/build` klasörüne kaydedilir.

### 🔸 Backend
```bash
cd practice-for-spring
mvn clean package
```
Oluşan `.jar` dosyası `target/` klasöründe bulunur.  
İstenirse React build’i Spring Boot’un `resources/static/` altına taşınarak tek jar içinde servis edilebilir.

---

## 🧑‍💻 Geliştirici

**[aydog4nn](https://github.com/aydog4nn)**  
🎓 Bilgisayar Mühendisliği öğrencisi  
💬 “Baba Spring`de akanzi.”

---


## 💬 Ek Notlar
- Proje monorepo (tek depo) yapısına sahiptir.  
- IntelliJ IDEA veya VS Code ile kolayca açılıp iki terminalde çalıştırılabilir.  
- Geliştirme sürecinde **CORS**, **JSON eşleşmeleri** ve **submodule hataları** çözülmüştür.  
- Backend (Spring Boot) ve Frontend (React) tamamen entegre halde sorunsuz çalışmaktadır.

---
