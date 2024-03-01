package com.example.warzone.init;

import com.example.warzone.dtos.*;
import com.example.warzone.servises.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    private ModelMapper modelMapper;
    private AttachmentService attachmentService;
    private GunService gunService;
    private UsersService usersService;
    private LoadoutService loadoutService;
    private PerksService perksService;
    private MetaListService metaListService;
    private NerfsAndBuffsService nerfsAndBuffsService;
    private LoadoutGunService loadoutGunService;
    private CamoService camoService;

    @Autowired
    public Main(ModelMapper modelMapper, AttachmentService attachmentService, GunService gunService, UsersService usersService, LoadoutService loadoutService, PerksService perksService, MetaListService metaListService, NerfsAndBuffsService nerfsAndBuffsService, LoadoutGunService loadoutGunService) {
        this.modelMapper = modelMapper;
        this.attachmentService = attachmentService;
        this.gunService = gunService;
        this.usersService = usersService;
        this.loadoutService = loadoutService;
        this.perksService = perksService;
        this.metaListService = metaListService;
        this.nerfsAndBuffsService = nerfsAndBuffsService;
        this.loadoutGunService = loadoutGunService;
    }

    @Override
    public void run(String... args){
        seedData();
    }

    private void seedData() {

//        // Создайте и зарегистрируйте новый CamoDto
//        CamoDto camoDto = new CamoDto();
//        camoDto.setTitle("Название камуфляжа");
//        camoDto.setDescription("Описание камуфляжа");
//        camoDto.setImage("URL изображения");
//        camoDto.setStatus(true);
//
//        camoDto = camoService.register(camoDto);

        UsersDto admin = new UsersDto(null, "vadim@mail.ru", "Vadim", "AngryL1on", "admin hahaha",
                "non", "http://fubrufbebnf", "123456789", 50765);
        admin = usersService.register(admin);

//        GunDto gun1 = new GunDto(null,"Kastov 545", "Assault Rifles", "MW2");
//        gun1 = gunService.register(gun1);

//        NerfsAndBuffsDto nerfsAndBuffs1 = new NerfsAndBuffsDto(null, gun1, "10.10.2020", "name gun",
//                true, "changes");
//        nerfsAndBuffs1 = nerfsAndBuffsService.register(nerfsAndBuffs1);



        LoadoutDto loadout1 = new LoadoutDto(null, admin, "perks", "guns", "description",
                "10.10.2020", "11.10.2020", "yes");
        loadout1 = loadoutService.register(loadout1);

        PerksDto perk1 = new PerksDto(null, loadout1, "1/2", "Mountaineer", "Reduced drop damage.");
        perk1 = perksService.register(perk1);

        MetaListDto metaList1 = new MetaListDto(null, "WSP Swarm", "Close Range", "gun1", "category",
                "underBarrel", "Barrel", "stock",
                "optic", "laser");
        metaList1 = metaListService.register(metaList1);

//        LoadoutGunDto loadoutGun1 = new LoadoutGunDto(null, gun1, loadout1, metaList1, "WSP Swarm", "Close Range",
//                "underBarrel", "Barrel", "stock",
//                "optic", "laser");
//        loadoutGun1 = loadoutGunService.register(loadoutGun1);

//        AttachmentsDto attachments1 = new AttachmentsDto(null, loadoutGun1, "SA Brake Barrel", ".50 GS",
//                (short) 8, "Control of the horizontal component of recoil, Control of barrel drift, Vertical recoil", "Aim speed");
//        attachments1 = attachmentService.register(attachments1);
    }
}
