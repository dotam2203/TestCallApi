# TestCallApi
# Mô tả
- Dựa trên mô hình MVVM (Model - View - ViewModel), Data Binding, Coroutines
- Sử dụng Retrofit call api, RecyclerView hiển thị danh sách
Chi tết mô tả trong code
=============================
- Tối ưu code: 
  + Khởi tạo viewModel bên trong 1 abstract class để các class khác kế thừa
  + Sử dụng apply (rút ngắn số lần gọi tên biến)
  + Sử dụng Fragment bên trong một Activity chính => giúp tối ưu giao diện và chương trình
