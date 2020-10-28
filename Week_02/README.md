学习笔记

## Windows

1.管理员身份打开powershell

2.运行
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

3.执行choco install superbenchmarker

4.输入 sb

执行 sb -u http://localhost:8088/api/hello -c 20 -N 60

## Mac

1.执行brew install wrk
如果显式brew update很慢，可以ctrl+C打断更新

2.输入 wrk

执行 wrk -t8 -c40 -d60s http://localhost:8088/api/hello


## 垃圾收集器

收集器 | 命令 | 特点
---|--- | ---
串行 | -XX:+UseSerialGC | 单线程，串行执行，小堆时 FullGC 时间过长
并行 | -XX:+UseParallelGC | 多线程并行收集，吞吐量优先
CMS | +UseConcMarkSweepGC | 并发收集(用户线程可执行)，降低STW时间，标记清除会产生碎片。JAVA9废弃
G1 | -XX:+UseG1GC | CMS的升级版，吞吐量和低停顿兼顾，大堆有优势

