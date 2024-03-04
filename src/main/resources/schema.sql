create table if not exists Record(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    content VARCHAR(400) NOT NULL,
    createdDate TIMESTAMP
    );