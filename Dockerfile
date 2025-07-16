# 1. 使用官方 OpenJDK 作为基础镜像
FROM openjdk:21-slim

# 2. 设置工作目录
WORKDIR /app

# 3. 拷贝 jar 包到容器中
COPY target/*.jar app.jar

# 4. 启动应用
ENTRYPOINT ["java", "-server",
  "-Xms512m", "-Xmx1024m", "-Xmn200m",
  "-XX:MetaspaceSize=128m", "-XX:MaxMetaspaceSize=256m",
  "-XX:SurvivorRatio=8", "-Xss2M",
  "-XX:-UseAdaptiveSizePolicy", "-XX:+PrintPromotionFailure",
  "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=/app/oom.hprof",
  "-XX:+UseConcMarkSweepGC", "-XX:+CMSParallelRemarkEnabled",
  "-XX:CMSInitiatingOccupancyFraction=70",
  "-XX:+UseFastAccessorMethods", "-XX:+UseCMSInitiatingOccupancyOnly",
  "-XX:+PrintGCDetails", "-XX:+PrintGCDateStamps",
  "-XX:GCLogFileSize=100M", "-Xloggc:/app/gc.log",
  "-Dfile.encoding=UTF-8", "-XX:-OmitStackTraceInFastThrow",
  "-jar", "app.jar", "--spring.profiles.active=prod"
]
