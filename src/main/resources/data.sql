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

-- 사용자 데이터
INSERT INTO users (username, password, email, role, created_at, updated_at)
VALUES 
('admin', '$2a$10$rDkPvvAFV6GgJjXpYWYQeO9YQZQZQZQZQZQZQZQZQZQZQZQZQZQ', 'admin@example.com', 'ROLE_ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('user1', '$2a$10$rDkPvvAFV6GgJjXpYWYQeO9YQZQZQZQZQZQZQZQZQZQZQZQZQZQ', 'user1@example.com', 'ROLE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 게시판 데이터
INSERT INTO boards (name, description, created_at, updated_at)
VALUES 
('공지사항', '중요 공지사항을 확인하세요.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('자유게시판', '자유롭게 이야기를 나누세요.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 게시글 데이터
INSERT INTO posts (title, content, author_id, board_id, created_at, updated_at)
VALUES 
('환영합니다', '게시판에 오신 것을 환영합니다.', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('첫 번째 게시글', '자유게시판의 첫 번째 게시글입니다.', 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 댓글 데이터
INSERT INTO comments (content, author_id, post_id, created_at, updated_at)
VALUES 
('환영합니다!', 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('좋은 게시글이네요.', 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 