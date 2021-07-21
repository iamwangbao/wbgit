目前只完成了下载功能，运行程序后输入需要下载的URL，文件名，文件后缀，文件存放位置即可开始下载。下载中会显示下载速度，完成后显示下载开始时间和结束时间。后续预计加入下载进度显示，并且完成多线程功能（多线程下载多个文件，或者单个文件分为多个部分，由多线程分别下载）。



改动1：添加了进度显示，更正byte和KB的单位错误 2021/07/18

改动2：添加支持多个文件下载（设置最高下载十个，可以修改），添加单个线程顺序下载多个文件，并可以与多个线程下载单个文件后顺序完成多个文件下载进行对比。2021/07/22



At present, only the download function is completed. After running the program, enter the URL, file name, file suffix and file storage location to download. The download speed will be displayed in the download, and the download start time and end time will be displayed when the download is completed. It is expected to join the download progress display and complete the multi-threaded function (multi thread downloads multiple files, or a single file is divided into multiple parts and downloaded by multi thread respectively).



Change 1: add progress display, correct byte and KB unit error 2021/07/18

Change 2: add support for multiple file downloads (set the maximum number of downloads to 10, which can be modified), add a single thread to download multiple files in sequence, and compare with multiple threads to download multiple files in sequence after downloading a single file. 2021/07/22