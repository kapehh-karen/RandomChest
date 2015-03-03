# RandomChest
Плагин для рандомного виртуального сундука.

Команды:
<ul>
<li><code>/randomchest open <b>имя_сундука</b> [имя_игрока]</code> - открывает игроку <b>имя_игрока</b> (не обязательный параметр) сундук</li>
<li><code>/randomchest reload</code> - перезагружает плагин</li>
</ul>

Права:
<code>randomchest.use.[имя_сундука]</code> - права на открытие сундука

Пример конфига:
<pre>
# Logging
Debug: true
Chests:
  ChestName1: # системное название сундука
    Name: QWEEEEEEEEEE # название отображаемое в заголовке сундука
    Drop: true # если true, то вещи не взятые из сундука дропаются, если false не дропаются
    Contents: # содержимое сундука
      GoldBow1: # просто название пункта, ни на что не влияет, можно писать любое
        Id: 261
        Data: 0
        Name: XDDDDDDDDDDDDDD # своё название вещи
        Probability: 50 # вероятность появления в сундуке этой вещи
        MinQuantity: 1 # если же вещь появилась, то случайным образом выбирается
        MaxQuantity: 1 # количество от MinQuantity до MaxQuantity
        Enchantments: # список чар для итема
          Enchantment1:
            Enchantment: ARROW_DAMAGE
            Level: 1
            Probability: 100 # вероятность появления этого чара на вещи
          Enchantment2:
            Enchantment: ARROW_FIRE
            Level: 2
            Probability: 50
      IronSpare3:
        Id: 1
        Data: 0
        Probability: 100
        MinQuantity: 1
        MaxQuantity: 2
      QweQweMfk:
        Id: 260
        Data: 0
        Probability: 50
        MinQuantity: 64
        MaxQuantity: 512
      laz:
        Id: 351
        Data: 4
        Probability: 50
        MinQuantity: 10
        MaxQuantity: 60
  Che:
    Name: CHEHEHEHEHEH
    Drop: false
    Contents:
      Mimimi:
        Id: 276
        Data: 0
        Name: "БОЖЕСТВЕННЫЙ МЕЧ"
        Probability: 100
        MinQuantity: 5
        MaxQuantity: 10
        Enchantments:
          Enchantment1:
            Enchantment: DAMAGE_ALL
            Level: 10
            Probability: 100
</pre>

Пример записи в лог:
<pre>
[21.02.2015 17:49:30] Player 'player' open chest 'ChestName1' with contents {ItemStack{STONE x 2}, ItemStack{INK_SACK x 38}, }
</pre>
Что означает, что игроку player был открыт сундук ChestName1 в котором выпало 2 камня и 38 лазурита.
