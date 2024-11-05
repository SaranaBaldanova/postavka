CREATE TABLE students (
                          id bigserial PRIMARY KEY,
                          full_name VARCHAR(255) NOT NULL,
                          record_book_number VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          phone_number VARCHAR(255) NOT NULL
);

INSERT INTO students (id, full_name, record_book_number, email, phone_number)
VALUES
    (1, 'Алексей Алексеев', '000001', 'alexey.alekseev@example.com', '111-222-3333'),
    (2, 'Ольга Ольгина', '000002', 'olga.olgina@example.com', '222-333-4444'),
    (3, 'Дмитрий Дмитриев', '000003', 'dmitry.dmitriev@example.com', '333-444-5555'),
    (4, 'Виктор Викторов', '000004', 'victor.victorov@example.com', '444-555-6666'),
    (5, 'Екатерина Екатеринова', '000005', 'ekaterina.ekaterinova@example.com', '555-666-7777'),
    (6, 'Игорь Игорев', '000006', 'igor.igorev@example.com', '666-777-8888');