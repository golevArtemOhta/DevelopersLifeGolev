# DevelopersLifeGolev

Приложение загружает рандомный пост с Gif'кой с сайта developerslife.ru
Кнопка "Next" загружает следующий пост. Кнопка "Back" - возвращает к предыдущему, загруженному в кэш.
При попытке нажатия кнопки "Back" с первого загруженного поста появляется тост "В кэше пусто!".
Ответы от API закешированы. 
Загрузка Gif сопровождается Progress Bar. Успешность загрузки - символизирует загруженная Gif.
С помощью checkbox'a можно переключится на загрузку из последнего (latest), горячее(hot), популярное(top) и рандомное (random)
Загрузка Api из "Hot" - приходит пустая, поэтому в textView - появляется текст "The "hot" tab is empty"

Приложение написано на языке Kotlin. 
В приложении использовались Fragment'ы, ViewModel, LiveData.
Запросы данных с сервера выполнены с использованием Retrofit 2 и Coroutines.
Для работы с gif-изображениями использовался Glide.
Для перевернутого экрана создано landScape activity



Скриншоты экрана:

![Image alt](https://github.com/golevArtemOhta/DevelopersLifeGolev/blob/master/developersLifeApp.jpg)
