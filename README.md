# RandomChest
Плагин для рандомного виртуального сундука.

Команды:
<ul>
<li>/randomchest open <chestname> [playername]</li>
<li>/randomchest reload</li>
</ul>

Пример конфига:
<pre>
# Logging
Debug: true
Chests:
  ChestName1:
    GoldBow1:
      Id: 261
      Data: 0
      Name: Лучик
      Probability: 50
      MinQuantity: 1
      MaxQuantity: 1
      Enchantments:
        Enchantment1:
          Enchantment: ARROW_DAMAGE
          Level: 1
          Probability: 100
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
    lazurit:
      Id: 351
      Data: 4
      Probability: 50
      MinQuantity: 10
      MaxQuantity: 60
  Che:
    Mimimi:
      Id: 276
      Data: 0
      Name: БОЖЕСТВЕННЫЙ МЕЧ
      Probability: 100
      MinQuantity: 5
      MaxQuantity: 10
      Enchantments:
        Enchantment1:
          Enchantment: DAMAGE_ALL
          Level: 10
          Probability: 100
</pre>
Id, Data - предмет
Name (опционально) - отображаемое название предмета в инвентаре
Probability - шанс выпадения (вещественное число, от 0.0 до 100.0)
MinQuantity, MaxQuantity - минимальное и максимальное количество которое может выпасть
Enchantments - чары накладываемые на предмет

Пример записи в лог:
<pre>
[21.02.2015 17:49:30] Player 'player' open chest 'ChestName1' with contents {ItemStack{STONE x 2}, ItemStack{INK_SACK x 38}, }
</pre>
Что означает, что игроку player был открыт сундук ChestName1 в котором выпало 2 камня и 38 лазурита.
