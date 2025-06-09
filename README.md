## 라이선스
Copyright © 2025 Jaehyun KIM. All Rights Reserved.

# Secure Future - 2032 보안 통합 관리 시스템

## 프로젝트 개요
Jaehyun KIM의 보안 전문성을 바탕으로 2032년을 대비한 혁신적인 보안 솔루션입니다. AI 기반 위협 예측, IoT 디바이스 통합 보안 관리, 실시간 DLP 모니터링 등 최신 보안 기술을 통합한 차세대 보안 시스템입니다.

## 프로젝트 구조 및 컴포넌트 설명

### 1. 핵심 애플리케이션 (`jaehyun.kim.SecureFutureApplication`)
- Spring Boot 기반의 메인 애플리케이션 클래스
- 애플리케이션의 시작점으로, 모든 컴포넌트를 초기화하고 실행
- 자동 설정 및 컴포넌트 스캔을 통해 시스템 구성

### 2. 보안 모듈 (`jaehyun.kim.security`)
#### 2.1 AI 기반 위협 예측 시스템 (`AIThreatPredictor`)
- TensorFlow를 활용한 실시간 네트워크 패턴 분석
- 이상 행동 패턴 감지 및 자동 대응
- 위협 점수 기반의 위험도 평가
- 자동화된 대응 전략 생성

#### 2.2 보안 모델 (`model` 패키지)
- `NetworkData`: 네트워크 트래픽 데이터 모델
  - 소스/목적지 IP, 포트 정보
  - 프로토콜 및 패킷 데이터
  - 대역폭 사용량 및 연결 상태
  - 이상 패턴 감지 및 위험도 계산 기능

- `ThreatPrediction`: 위협 예측 결과 모델
  - 위협 점수 및 유형
  - 대응 전략
  - 예측 시간 및 신뢰도
  - 우선순위 레벨 결정 기능

### 3. IoT 모듈 (`jaehyun.kim.iot`)
#### 3.1 IoT 디바이스 관리 시스템 (`IoTDeviceManager`)
- 실시간 디바이스 상태 모니터링
- 동적 보안 정책 적용
- 이상 행동 패턴 감지
- 자동화된 보안 프로토콜 실행
- 디바이스 등록 및 관리 기능

#### 3.2 IoT 모델 (`model` 패키지)
- `IoTDevice`: IoT 디바이스 정보 모델
  - 디바이스 ID 및 유형
  - 제조사 및 펌웨어 버전
  - 상태 및 메트릭 정보
  - 보안 정책 관리 기능

- `SecurityPolicy`: 보안 정책 모델
  - 정책 ID 및 이름
  - 접근 규칙 및 프로토콜
  - 암호화 요구사항
  - 인증 방식 설정
  - 동적 정책 업데이트 기능

### 4. 데이터베이스 모듈
#### 4.1 엔티티 클래스
- `NetworkData`: 네트워크 트래픽 데이터 엔티티
  - JPA 엔티티로 구현 (`@Entity`)
  - ID 자동 생성 (`@GeneratedValue`)
  - 대역폭 사용량, 연결 상태, 위험도 점수 필드 추가

- `ThreatPrediction`: 위협 예측 결과 엔티티
  - NetworkData와 ManyToOne 관계 설정
  - 위협 점수, 유형, 설명, 타임스탬프 필드
  - 응답 전략, 신뢰도, 우선순위 레벨 추가

- `IoTDevice`: IoT 디바이스 정보 엔티티
  - SecurityPolicy와 ManyToOne 관계 설정
  - 디바이스 상태 모니터링 메서드 구현
  - 보안 정책 업데이트 기능 구현

- `SecurityPolicy`: 보안 정책 엔티티
  - 허용된 프로토콜을 ElementCollection으로 관리
  - 접근 규칙, 인증 방식, 동적 정책 여부 필드
  - 암호화 및 인증 요구사항 설정

#### 4.2 데이터베이스 설정
- H2 데이터베이스 사용 (메모리 기반)
- JPA/Hibernate를 통한 객체-관계 매핑
- 자동 테이블 생성 및 스키마 업데이트
- H2 콘솔을 통한 데이터베이스 관리

## 주요 기능

### 1. AI 기반 보안 위협 예측
- TensorFlow를 활용한 실시간 네트워크 패턴 분석
- 이상 행동 패턴 감지 및 자동 대응
- 위협 점수 기반의 위험도 평가
- 자동화된 대응 전략 생성

### 2. IoT 디바이스 통합 보안
- 실시간 디바이스 상태 모니터링
- 동적 보안 정책 적용
- 이상 행동 패턴 감지
- 자동화된 보안 프로토콜 실행

### 3. 확장 가능한 아키텍처
- Spring Boot 기반의 모듈식 설계
- 마이크로서비스 아키텍처 지원
- 실시간 데이터 처리 및 분석
- 고성능 동시성 처리

### 4. 보안 기능
- DLP(Data Loss Prevention) 통합
- 실시간 위협 감지 및 대응
- 자동화된 보안 인시던트 처리
- 보안 로그 관리 및 분석

### 5. 데이터베이스 기능
- JPA를 통한 객체-관계 매핑
- 자동 테이블 생성 및 스키마 관리
- 실시간 데이터 저장 및 조회
- H2 콘솔을 통한 데이터베이스 모니터링
- 파일 기반 데이터 영속성

## 기술 스택
- Java 21
- Spring Boot 3.2.0
- TensorFlow
- JPA/Hibernate
- H2 Database
- Lombok

## Windows 11 설치 가이드

### 1. JDK 21 설치
1. [Adoptium OpenJDK 21](https://adoptium.net/) 웹사이트 방문
2. Windows x64 MSI Installer 다운로드 (약 152.80 MB)
3. 다운로드한 설치 파일 실행
4. Custom Setup에서 다음 옵션 선택:
   - [x] Set JAVA_HOME variable
   - [x] Add to PATH
   - [x] Associate .jar files with Java Runtime
   - [x] Source Code
5. 설치 완료 후 확인:
   - Windows 키 + R → cmd 입력 → 확인
   - 다음 명령어 실행:
     ```bash
     java -version
     javac -version
     ```

### 2. Maven 설치
1. [Maven 다운로드 페이지](https://maven.apache.org/download.cgi) 방문
2. `apache-maven-3.9.9-bin.zip` 파일 다운로드
3. 다운로드한 zip 파일을 `C:\Program Files\Apache\maven`에 압축 해제
4. 시스템 환경 변수 설정:
   - Windows 키 + R → sysdm.cpl 입력 → 확인
   - 고급 탭 → 환경 변수 클릭
   - 시스템 변수에서 새로 만들기:
     - 변수 이름: `MAVEN_HOME`
     - 변수 값: `C:\Program Files\Apache\maven`
   - Path 변수 선택 → 편집 → 새로 만들기:
     - `%MAVEN_HOME%\bin` 추가
5. 설치 확인:
   - 새 명령 프롬프트 창 열기
   - 다음 명령어 실행:
     ```bash
     mvn -version
     ```

### 3. 프로젝트 설정
1. 프로젝트 다운로드:
   ```bash
   # 원하는 위치에서 명령 프롬프트 실행
   git clone https://github.com/jaehyun.kim/secure-future.git
   cd secure-future
   ```

2. 의존성 설치 및 빌드:
   ```bash
   mvn clean install
   ```

### 4. 애플리케이션 실행
1. 기본 실행:
   ```bash
   mvn spring-boot:run
   ```

2. 특정 포트로 실행 (8080 포트가 사용 중인 경우):
   ```bash
   mvn spring-boot:run -Dserver.port=8081
   ```

3. 실행 확인:
   - 웹 브라우저에서 `http://localhost:8080` 접속
   - 또는 `http://localhost:8081` (포트 변경 시)

### 5. 문제 해결
1. 포트 충돌 시:
   - `application.properties` 파일에서 포트 변경:
     ```properties
     server.port=8081
     ```

2. 메모리 부족 시:
   ```bash
   mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xmx4g -Xms2g"
   ```

3. 의존성 문제 시:
   ```bash
   mvn clean install -U
   ```

### 6. 개발 환경 설정
1. IDE 설치 (선택사항):
   - [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) 다운로드 및 설치
   - 또는 [Visual Studio Code](https://code.visualstudio.com/) + Java Extension Pack

2. Lombok 플러그인 설치 (IDE 사용 시 필수)

## 시스템 요구사항
- Windows 11
- JDK 21
- Maven 3.9.9
- 최소 8GB RAM
- 100GB 이상의 저장 공간
- 인터넷 연결

# Java 개발 환경 설정 가이드

## OpenJDK 21 설치 방법

1. [Adoptium OpenJDK 21](https://adoptium.net/) 웹사이트에서 설치 파일을 다운로드합니다.

2. Custom Setup에서 다음 설정을 권장합니다:

   ### 설치 옵션 (Installation Options)
   - [x] Set JAVA_HOME variable
   - [x] Add to PATH
   - [x] Associate .jar files with Java Runtime

   ### 설치 경로 (Installation Directory)
   - 기본 경로 사용 권장: `C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot`
   - 경로에 공백이 없도록 주의

   ### 추가 기능 (Additional Features)
   - [x] Source Code
   - [ ] Public JRE (선택사항)

   ### 시작 메뉴 폴더 (Start Menu Folder)
   - 기본값 사용 권장

3. 설치 완료 후 확인 방법:
   ```bash
   java -version
   javac -version
   ```

## Maven 설치 방법

1. [Maven 다운로드 페이지](https://maven.apache.org/download.cgi)에서 다음 파일을 다운로드:
   - Binary zip archive: `apache-maven-3.9.6-bin.zip`
   - (Source zip archive는 선택사항)

2. 설치 단계:
   - 다운로드한 zip 파일을 원하는 위치에 압축 해제 (예: `C:\Program Files\Apache\maven`)
   - 시스템 환경 변수 설정:
     1. 시스템 환경 변수 편집 열기
     2. 새 시스템 변수 추가:
        - 변수 이름: `MAVEN_HOME`
        - 변수 값: Maven 설치 경로 (예: `C:\Program Files\Apache\maven`)
     3. Path 변수에 추가:
        - `%MAVEN_HOME%\bin`

3. 설치 확인:
   ```bash
   mvn -version
   ```

## 설치 설정의 이점
- JAVA_HOME 환경 변수 설정으로 Java 개발 도구들이 JDK 위치를 쉽게 찾을 수 있습니다
- PATH에 추가되어 명령 프롬프트에서 java 명령어를 바로 사용할 수 있습니다
- .jar 파일을 더블클릭으로 실행할 수 있습니다
- 소스 코드가 포함되어 있어 디버깅과 학습에 도움이 됩니다

## Java 프로그램 실행 방법

1. **간단한 Java 프로그램 작성하기**
   ```java
   // HelloWorld.java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```

2. **컴파일하기**
   - 명령 프롬프트(cmd)를 열고 소스 파일이 있는 디렉토리로 이동
   ```bash
   cd 프로젝트_경로
   javac HelloWorld.java
   ```

3. **실행하기**
   ```bash
   java HelloWorld
   ```

### 주의사항
- Java 파일의 이름은 반드시 클래스 이름과 동일해야 합니다 (예: `HelloWorld.java`)
- 컴파일된 파일은 `.class` 확장자를 가집니다
- 실행할 때는 `.class` 확장자를 제외하고 클래스 이름만 입력합니다


## 문제 해결 및 운영 기록 (2025-06-08)

### 1. Spring Boot 빌드 및 실행 오류 해결
- `spring-boot` 플러그인 미설치로 인한 빌드 실패 → `pom.xml`에 Spring Boot 플러그인 및 parent 추가, 버전 명시(`3.2.0`).
- 중복된 Main 클래스(`jaehyun.kim.SecureFutureApplication`, `kr.jaehyun.SecureFutureApplication`)로 인한 실행 오류 → `kr.jaehyun.SecureFutureApplication` 파일 삭제 및 `pom.xml`에 main class 지정.

### 2. 컴파일 오류 및 모델 클래스 추가
- 누락된 모델 클래스(`NetworkData`, `ThreatPrediction`, `IoTDevice`, `SecurityPolicy`) 직접 생성 및 패키지 구조에 맞게 배치.
- `IoTDevice`에 `isHealthy()`, `updateSecurityPolicy(SecurityPolicy)` 등 실제 사용되는 메서드 구현.
- `ThreatPrediction`에 생성자 추가(위협 점수, 유형, 설명 등 인자 받음).

### 3. 데이터베이스(H2) 설정 및 연결 문제 해결
- Spring Boot 실행 시 H2 DB 관련 오류 발생: `application.properties`에 H2 메모리 DB에서 파일 DB(`jdbc:h2:file:./testdb`)로 변경, H2 콘솔 원격 접속 허용 옵션 추가.
- H2 콘솔 접속 시 JDBC URL을 반드시 `jdbc:h2:file:./testdb`로 입력해야 정상 연결됨을 명시.
- 포트 충돌 시 프로세스 종료(`taskkill /F /PID ...`) 후 재실행.

### 4. JPA 엔티티 클래스 구현
- 모든 모델 클래스를 JPA 엔티티로 변환:
  - `@Entity`, `@Id`, `@GeneratedValue` 등 JPA 어노테이션 추가
  - 각 엔티티에 적절한 관계 매핑 설정 (`@ManyToOne`, `@ElementCollection` 등)
  - 엔티티 간 연관관계 설정 (예: `NetworkData` ↔ `ThreatPrediction`, `IoTDevice` ↔ `SecurityPolicy`)
  - 각 엔티티에 필요한 필드 추가 및 메서드 구현
  - Lombok 어노테이션(`@Data`, `@NoArgsConstructor` 등) 활용

### 5. 기타
- README에 실제 운영 중 발생한 문제와 해결 방법, JDBC URL 등 실전 팁을 기록하여 추후 유지보수 및 신규 개발자 온보딩에 참고할 수 있도록 함.

## 데이터베이스 설정

### H2 데이터베이스 설정
1. `pom.xml`에 H2 데이터베이스 의존성 추가:
   ```xml
   <dependency>
       <groupId>com.h2database</groupId>
       <artifactId>h2</artifactId>
       <scope>runtime</scope>
   </dependency>
   ```

2. `application.properties` 설정:
   ```properties
   # H2 Database Configuration
   spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

   # H2 Console Configuration
   spring.h2.console.enabled=true
   spring.h2.console.path=/h2-console
   spring.h2.console.settings.web-allow-others=false

   # JPA Configuration
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. H2 콘솔 접속:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: (비워두세요)

4. 주의사항:
   - H2 콘솔 접속 시 JDBC URL을 정확히 입력해야 합니다
   - 파일 기반 DB이므로 애플리케이션 종료 후에도 데이터가 유지됩니다
   - 포트 충돌 시 `taskkill /F /PID [프로세스ID]` 명령어로 프로세스 종료 후 재시작

### 데이터베이스 초기화
- `spring.jpa.hibernate.ddl-auto=update`: 엔티티 클래스 기반으로 테이블 자동 생성/수정
- `spring.jpa.show-sql=true`: SQL 쿼리 로그 출력
- 필요한 경우 `data.sql` 또는 `schema.sql` 파일을 `src/main/resources`에 추가하여 초기 데이터 설정 가능

### 테이블 생성 및 샘플 데이터
1. 테이블 생성 SQL:
```sql
-- NetworkData 테이블 생성
CREATE TABLE network_data (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    source_ip VARCHAR(50),
    destination_ip VARCHAR(50),
    port INT,
    protocol VARCHAR(20),
    timestamp BIGINT,
    payload BINARY,
    bandwidth_usage DOUBLE,
    connection_status VARCHAR(20),
    risk_score DOUBLE
);

-- ThreatPrediction 테이블 생성
CREATE TABLE threat_prediction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    threat_score DOUBLE,
    threat_type VARCHAR(50),
    description VARCHAR(255),
    timestamp BIGINT,
    response_strategy VARCHAR(255),
    confidence DOUBLE,
    priority_level INT,
    network_data_id BIGINT,
    FOREIGN KEY (network_data_id) REFERENCES network_data(id)
);

-- SecurityPolicy 테이블 생성
CREATE TABLE security_policy (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    policy_id VARCHAR(50),
    policy_name VARCHAR(100),
    device_type VARCHAR(50),
    requires_encryption BOOLEAN,
    requires_authentication BOOLEAN,
    max_connections INT,
    access_rules VARCHAR(255),
    authentication_method VARCHAR(50),
    is_dynamic BOOLEAN
);

-- SecurityPolicy 프로토콜 테이블 생성
CREATE TABLE security_policy_protocols (
    security_policy_id BIGINT,
    allowed_protocols VARCHAR(50),
    FOREIGN KEY (security_policy_id) REFERENCES security_policy(id)
);

-- IoTDevice 테이블 생성
CREATE TABLE iot_device (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    device_id VARCHAR(50),
    device_type VARCHAR(50),
    manufacturer VARCHAR(100),
    firmware_version VARCHAR(50),
    status VARCHAR(20),
    ip_address VARCHAR(50),
    last_seen BIGINT,
    is_secure BOOLEAN,
    metrics VARCHAR(255),
    security_policy_id BIGINT,
    FOREIGN KEY (security_policy_id) REFERENCES security_policy(id)
);
```

2. 샘플 데이터 삽입:
```sql
-- NetworkData 샘플 데이터
INSERT INTO network_data (source_ip, destination_ip, port, protocol, timestamp, bandwidth_usage, connection_status, risk_score)
VALUES 
('127.0.0.1', '127.0.0.2', 80, 'HTTP', 1717843560000, 1024.5, 'ESTABLISHED', 0.3),
('127.0.0.2', '127.0.0.3', 443, 'HTTPS', 1717843560000, 2048.7, 'ESTABLISHED', 0.1),
('127.0.0.3', '127.0.0.4', 22, 'SSH', 1717843560000, 512.3, 'ESTABLISHED', 0.8);

-- SecurityPolicy 샘플 데이터
INSERT INTO security_policy (policy_id, policy_name, device_type, requires_encryption, requires_authentication, max_connections, access_rules, authentication_method, is_dynamic)
VALUES 
('POL001', 'Standard IoT Policy', 'SENSOR', true, true, 100, 'RESTRICTED', 'TOKEN', true),
('POL002', 'Camera Policy', 'CAMERA', true, true, 50, 'RESTRICTED', 'CERTIFICATE', true);

-- SecurityPolicy 프로토콜 샘플 데이터
INSERT INTO security_policy_protocols (security_policy_id, allowed_protocols)
VALUES 
(1, 'HTTPS'),
(1, 'MQTT'),
(2, 'HTTPS'),
(2, 'RTSP');

-- IoTDevice 샘플 데이터
INSERT INTO iot_device (device_id, device_type, manufacturer, firmware_version, status, ip_address, last_seen, is_secure, security_policy_id)
VALUES 
('DEV001', 'SENSOR', 'Samsung', '1.0.0', 'ACTIVE', '127.0.0.100', 1717843560000, true, 1),
('DEV002', 'CAMERA', 'LG', '2.1.0', 'ACTIVE', '127.0.0.101', 1717843560000, true, 2);

-- ThreatPrediction 샘플 데이터
INSERT INTO threat_prediction (threat_score, threat_type, description, timestamp, response_strategy, confidence, priority_level, network_data_id)
VALUES 
(0.8, 'MALWARE', 'Suspicious file transfer detected', 1717843560000, 'BLOCK_AND_ALERT', 0.9, 1, 1),
(0.3, 'SCAN', 'Port scan detected', 1717843560000, 'MONITOR', 0.7, 2, 2);
```

3. 데이터 확인 쿼리:
```sql
-- 각 테이블의 데이터 확인
SELECT * FROM network_data;
SELECT * FROM iot_device;
SELECT * FROM security_policy;
SELECT * FROM security_policy_protocols;
SELECT * FROM threat_prediction;
```

주의사항:
- timestamp 필드는 밀리초 단위의 BIGINT 값으로 저장됩니다
- 외래 키 제약조건이 있으므로 테이블 생성 및 데이터 삽입 순서를 지켜야 합니다
- H2 콘솔에서 SQL을 실행할 때는 세미콜론(;)으로 구분된 각 문장을 개별적으로 실행해야 합니다

### 네트워크 데이터 수집 및 위협 분석

#### 1. 네트워크 데이터 수집기 (NetworkDataCollector)
- 1분마다 네트워크 인터페이스 모니터링
- 트래픽 데이터 수집 및 위험도 계산
- 주요 기능:
  - 네트워크 인터페이스 자동 감지
  - 트래픽 패턴 분석
  - 위험도 점수 계산
  - 실시간 데이터 저장

#### 2. 위협 분석기 (ThreatAnalyzer)
- 5분마다 위험도가 높은 트래픽 분석
- 주요 기능:
  - 위협 점수 계산
  - 위협 유형 판단 (MALWARE, SCAN, SUSPICIOUS, NORMAL)
  - 응답 전략 결정 (BLOCK_AND_ALERT, ALERT_AND_MONITOR, MONITOR, ALLOW)
  - 신뢰도 및 우선순위 계산

#### 3. 데이터 조회 기능
```sql
-- 최근 위협 예측 결과
SELECT * FROM threat_prediction ORDER BY timestamp DESC;

-- 위험도가 높은 트래픽
SELECT * FROM network_data WHERE risk_score >= 0.7 ORDER BY risk_score DESC;

-- 위협 유형별 통계
SELECT threat_type, COUNT(*) as count, AVG(threat_score) as avg_score 
FROM threat_prediction 
GROUP BY threat_type 
ORDER BY count DESC;

-- 프로토콜별 위험도 분석
SELECT protocol, COUNT(*) as count, AVG(risk_score) as avg_risk_score
FROM network_data 
GROUP BY protocol 
ORDER BY avg_risk_score DESC;

-- IP 주소별 위험도 분석
SELECT source_ip, COUNT(*) as count, AVG(risk_score) as avg_risk_score
FROM network_data 
GROUP BY source_ip 
HAVING avg_risk_score > 0.5 
ORDER BY avg_risk_score DESC;
```

#### 4. 위험도 계산 기준
- 프로토콜 기반 위험도:
  - SSH: +0.3
  - HTTP: +0.1
  - HTTPS: +0.05
  - FTP: +0.4
  - TELNET: +0.5

- 포트 기반 위험도:
  - 1024 미만: +0.2
  - SSH(22): +0.1
  - Telnet(23): +0.2
  - FTP(21): +0.15

- 대역폭 사용량 기반 위험도:
  - 1000 초과: +0.1
  - 2000 초과: +0.2

- IP 주소 기반 위험도:
  - 로컬호스트(127.0.0.*): -0.1

#### 5. 위협 유형 판단 기준
- MALWARE: 위협 점수 >= 0.8
- SCAN: 위협 점수 >= 0.6
- SUSPICIOUS: 위협 점수 >= 0.4
- NORMAL: 위협 점수 < 0.4

#### 6. 응답 전략 결정 기준
- BLOCK_AND_ALERT: 위협 점수 >= 0.8
- ALERT_AND_MONITOR: 위협 점수 >= 0.6
- MONITOR: 위협 점수 >= 0.4
- ALLOW: 위협 점수 < 0.4

#### 7. 우선순위 레벨
- 1: 최우선 (위협 점수 >= 0.8)
- 2: 높음 (위협 점수 >= 0.6)
- 3: 중간 (위협 점수 >= 0.4)
- 4: 낮음 (위협 점수 < 0.4)