# RiverRideTickets
### REST API сервис для работы с данными в выбранной предметной области – «Покупка билетов на речную прогулку».

Бизнес-логика реализуется через следующие сценарии.
Сценарий 1. Покупка билета с расчетом стоимости в зависимости от его типа.
1.	Пользователь выбирает рейс.
2.	Система проверяет количество доступных билетов на нем.
3.	Пользователь вводит данные и выбирает категорию билета (взрослый, ребенок, студент, пенсионер, ветеран)
4.	Система рассчитывает итоговую стоимость билета с учетом скидки для конкретной категории. Создает запись о билете в базе данных.

Сценарий 2. Возврат билета, если не истек допустимый срок (12 часов до отправления).
1.	Пользователь отправляет запрос в систему на возврат билета.
2.	Система сравнивает текущее время и время отправления по билету.
3.	Если текущее время меньше 12 часов до отправления, пользователь получает отказ в возврате.
4.	Если больше или равно 12 часам до отправления, статус билета в базе данных меняется на "REFUNDED", количество доступных мест на рейсе увеличивается.

Сценарий 3. Подбор рейсов по заданным пользователем критериям.
1.	Пользователь вводит интересующие критерии (количество доступных мест на рейсе, точка отправления или прибытия, наличие кафе или открытой палубы на теплоходе, дата речной прогулки).
2.	Система анализирует все существующие в базе данных рейсы.
3.	Пользователь получает список доступных рейсов.

### Демонстрация работы.
Сценарий 1. POST-запрос на покупку билета: *http://localhost:8080/ticket/purchase?voyageId=29&firstName=Мария&lastName=Кузнецова&email=kuznetsova@gmail.com&ticketType=ВЗРОСЛЫЙ*
![image](https://github.com/user-attachments/assets/9205db17-a750-4110-8233-dd5c63be2db4)

Сценарий 2. POST-запрос на возврат билета: *http://localhost:8080/ticket/refund/8*
![image](https://github.com/user-attachments/assets/23dfe930-3449-4259-aa3f-bd0639d9d1ce)

Сценарий 3. GET-запрос на поиск рейсов по введенным критериям: *http://localhost:8080/voyages/search?needSeats=3&startPoint=Северный речной вокзал&cafeAvailability=true*
![image](https://github.com/user-attachments/assets/6939cdc5-bdac-4e2e-9330-4f65a0015266)
