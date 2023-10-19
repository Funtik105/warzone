package com.example.warzone.init;

import com.example.warzone.dtos.*;
import com.example.warzone.servises.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private GunService gunService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private LoadoutService loadoutService;
    @Autowired
    private PerksService perksService;
    @Autowired
    private MetaListService metaListService;
    @Autowired
    private NerfsAndBuffsService nerfsAndBuffsService;
    @Autowired
    private LoadoutGunService loadoutGunService;

    @Override
    public void run(String... args){
        seedData();
    }

    private void seedData() {

        UsersDto admin = new UsersDto(null, "vadim@mail.ru", "Vadim", "AngryL1on", "admin hahaha",
                "non", "http://fubrufbebnf", "123456789", 50765);
        admin = usersService.register(admin);

        GunDto gun1 = new GunDto(null, "m4a4", "assault rifle", "hz");
        gun1 = gunService.register(gun1);

        NerfsAndBuffsDto nerfsAndBuffs1 = new NerfsAndBuffsDto(null, gun1, "10.10.2020", "name gun",
                true, "changes");
        nerfsAndBuffs1 = nerfsAndBuffsService.register(nerfsAndBuffs1);

        LoadoutDto loadout1 = new LoadoutDto(null, admin, "perks", "guns", "description",
                "10.10.2020", "11.10.2020", "yes");
        loadout1 = loadoutService.register(loadout1);

        PerksDto perk1 = new PerksDto(null, loadout1, "type", "name", "description");
        perk1 = perksService.register(perk1);

        MetaListDto metaList1 = new MetaListDto(null, "name", "range", "gun1", "category",
                "attachment1", "attachment costomization1", "attachment2",
                "attachment costomization2", "attachment3",
                "attachment costomization3", "attachment4",
                "attachment costomization4", "attachment5",
                "attachment costomization5");
        metaList1 = metaListService.register(metaList1);

        LoadoutGunDto loadoutGun1 = new LoadoutGunDto(null, gun1, loadout1, metaList1, "name", "range",
                "attachment1", "attachment costomization1", "attachment2",
                "attachment costomization2", "attachment3",
                "attachment costomization3", "attachment4",
                "attachment costomization4", "attachment5",
                "attachment costomization5");
        loadoutGun1 = loadoutGunService.register(loadoutGun1);

        AttachmentsDto attachments1 = new AttachmentsDto(null, loadoutGun1, "name", "name weapon",
                (short) 3, "advantage", " disadvantages", "settingLimits");
        attachments1 = attachmentService.register(attachments1);
    }
}
