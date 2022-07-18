package com.example.instagramclone.api

import com.example.instagramclone.models.Comment
import com.example.instagramclone.models.Post
import com.example.instagramclone.models.User


val users = listOf<User>(
    User(
        id = 7,
        email = "michael.lawson@reqres.in",
        firstName = "Michael",
        lastName = "Lawson",
        avatar = "https://reqres.in/img/faces/7-image.jpg",
        alreadySeen = true,
    ),
    User(
        id = 8,
        email = "lindsay.ferguson@reqres.in",
        firstName = "Lindsay",
        lastName = "Ferguson",
        avatar = "https://reqres.in/img/faces/8-image.jpg",
        alreadySeen = true,
    ),
    User(
        id = 9,
        email = "tobias.funke@reqres.in",
        firstName = "Tobias",
        lastName = "Funke",
        avatar = "https://reqres.in/img/faces/9-image.jpg",
        alreadySeen = false,
    ),
    User(
        id = 10,
        email = "byron.fields@reqres.in",
        firstName = "Byron",
        lastName = "Fields",
        avatar = "https://reqres.in/img/faces/10-image.jpg",
        alreadySeen = false,
    ),
    User(
        id = 11,
        email = "george.edwards@reqres.in",
        firstName = "George",
        lastName = "Edwards",
        avatar = "https://reqres.in/img/faces/11-image.jpg",
        alreadySeen = false,
    ),
    User(
        id = 12,
        email = "rachel.howell@reqres.in",
        firstName = "Rachel",
        lastName = "Howell",
        avatar = "https://reqres.in/img/faces/12-image.jpg",
        alreadySeen = false,
    )
)

val posts = listOf(
    Post(
        id = 1,
        title = "accusamus beatae ad facilis cum similique qui sunt",
        url = "https://randompicturegenerator.com/img/lion-generator/ga94f8a13e081e8235cfe3bf6e18d1c032286cfc4b94be3409cf551e7e5c28e78d18becf8e6c234b4b66bf06d61bee401_640.jpg",
        user = users[4],
        like = true,
    ),
    Post(
        id = 2,
        title = "reprehenderit est deserunt velit ipsam",
        url = "https://randompicturegenerator.com/img/national-park-generator/gc13e35845de38e0de92d16a7f963a5f357a25a3f0addc98e634e56f31747aba187cd9b2c967f9433e05d07d74796615a_640.jpg",
        user = users[3],
        like = true,
    ),
    Post(
        id = 3,
        title = "officia porro iure quia iusto qui ipsa ut modi",
        url = "https://randompicturegenerator.com/img/national-park-generator/ga38326a66bb4cee5c1800557aec188712b84090e93c6ceae404ad4d1fd995ec7a2336b25b78bee182a83b145b29178fb_640.jpg",
        user = users[1],
        like = false,
    ),
    Post(
        id = 4,
        title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
        url = "https://randompicturegenerator.com/img/national-park-generator/g29ff89b1f7bed11af7057d85ee19d8288eca5973ffc46bebe07230313b225c898a2cc10fa22c262e46c1b9a46e4de15e_640.jpg",
        user = users[2],
        like = false,
    ),
    Post(
        id = 5,
        title = "natus nisi omnis corporis facere molestiae rerum in",
        url = "https://randompicturegenerator.com/img/national-park-generator/gcaedd8dc017e0983b291c0725fb188c9371ed9052ea439029286d6a6565d82a3554c204b2c2d46665dab91ac86de68e2_640.jpg",
        user = users[5],
        like = false,
    ),
    Post(
        id = 6,
        title = "accusamus ea aliquid et amet sequi nemo",
        url = "https://randompicturegenerator.com/img/national-park-generator/g41029de0a3156ed940a29e808f8f73b4c171b65903325f2f2319dfe5a7eed8738a586ca5d66547d91aca5ecb75370677_640.jpg",
        user = users[2],
        like = false,
    ),
    Post(
        id = 7,
        title = "officia delectus consequatur vero aut veniam explicabo molestias",
        url = "https://randompicturegenerator.com/img/national-park-generator/gc1cf7f07b48c419b042dc4f085ba1320335bcab92508f0871004623cd28abbfca600319473c9331bd2a0058b68b5629a_640.jpg",
        user = users[3],
        like = false,
    ),
    Post(
        id = 8,
        title = "aut porro officiis laborum odit ea laudantium corporis",
        url = "https://randompicturegenerator.com/img/national-park-generator/g9a6542f4d0ccf6052e5c2094302e1e425e51bc6a1d5c26041af3a824bedb0b9f8a5f7784eebc7861d082772456bcf0fa_640.jpg",
        user = users[5],
        like = true,
    ),
    Post(
        id = 9,
        title = "qui eius qui autem sed",
        url = "https://randompicturegenerator.com/img/national-park-generator/ge189b3ac7a2c7b572f95e156382c641a80183d761c0242a6e9fb11beac41cb69a40af459035dcc6afc6e0ca28120ed85_640.jpg",
        user = users[4],
        like = true,
    ),
    Post(
        id = 10,
        title = "beatae et provident et ut vel",
        url = "https://randompicturegenerator.com/img/national-park-generator/g7cafc5a41bf022e989475678fd2e5258aecbea766059619856d014f2d497d4005343e1342f2dd8d138cfc23ec2a48296_640.jpg",
        user = users[3],
        like = false,
    ),
    Post(
        id = 11,
        title = "nihil at amet non hic quia qui",
        url = "https://randompicturegenerator.com/img/national-park-generator/gafcf50a35932f2f891a05a6ab56b9d2f9604880cb201c8e34222d6afdc01ba0483c80fa80a805cfe779c84f8d2d71002_640.jpg",
        user = users[2],
        like = true,
    ),
    Post(
        id = 12,
        title = "mollitia soluta ut rerum eos aliquam consequatur perspiciatis maiores",
        url = "https://randompicturegenerator.com/img/national-park-generator/g910366c05c4459307f561917bf95c600007b71f03f97cdcac8f5599d9e128f754238f107e82df9e03cb531b6fb4d9197_640.jpg",
        user = users[1],
        like = false,
    ),
    Post(
        id = 13,
        title = "repudiandae iusto deleniti rerum",
        url = "https://randomwordgenerator.com/img/picture-generator/52e9d3474354ae14f1dc8460962e33791c3ad6e04e507749772f78d4954dcc_640.jpg",
        user = users[0],
        like = true,
    ),
)

val comments = listOf<Comment>(
    Comment(
        name = "id labore ex et quam laborum",
        body = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
    ),
    Comment(
        name = "quo vero reiciendis velit similique earum",
        body = "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"
    ),
    Comment(
        name = "odio adipisci rerum aut animi",
        body = "quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione"
    ),
    Comment(
        name = "alias odio sit",
        body = "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati"
    ),
    Comment(
        name = "vero eaque aliquid doloribus et culpa",
        body = "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
    ),
    Comment(
        name = "et fugit eligendi deleniti quidem qui sint nihil autem",
        body = "doloribus at sed quis culpa deserunt consectetur qui praesentium\naccusamus fugiat dicta\nvoluptatem rerum ut voluptate autem\nvoluptatem repellendus aspernatur dolorem in"
    ),
    Comment(
        name = "repellat consequatur praesentium vel minus molestias voluptatum",
        body = "maiores sed dolores similique labore et inventore et\nquasi temporibus esse sunt id et\neos voluptatem aliquam\naliquid ratione corporis molestiae mollitia quia et magnam dolor"
    ),
    Comment(
        name = "et omnis dolorem",
        body = "ut voluptatem corrupti velit\nad voluptatem maiores\net nisi velit vero accusamus maiores\nvoluptates quia aliquid ullam eaque"
    ),
    Comment(
        name = "provident id voluptas",
        body = "sapiente assumenda molestiae atque\nadipisci laborum distinctio aperiam et ab ut omnis\net occaecati aspernatur odit sit rem expedita\nquas enim ipsam minus"
    ),
    Comment(
        name = "eaque et deleniti atque tenetur ut quo ut",
        body = "voluptate iusto quis nobis reprehenderit ipsum amet nulla\nquia quas dolores velit et non\naut quia necessitatibus\nnostrum quaerat nulla et accusamus nisi facilis"
    ),
)