# 一些springboot项目的例子
1. demo-web中通过@EnableMonitor引入demo-monitor中的rest接口，可以demo-web中直接访问demo-monitor的/monitor/test接口
2. demo-monitor项目中通过MonitorAutoConfiguration类将```cn.maitian.demo.monitor```命名空间中的bean放入容器
3. demo-starter项目是一个springboot-stater示例，在demo-web中引入
