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

## 기술 스택
- Java 21
- Spring Boot 3.2.0
- TensorFlow
- JPA
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

## 라이선스
Copyright © 2025 Jaehyun KIM. All Rights Reserved.