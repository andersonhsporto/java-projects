@RestController
@RequestMapping("/families")
public class FamilyController {

    @Autowired
    FamilyRepository familyRepository;

    @GetMapping
    List<Family> getFamilies() {
        return familyRepository.findAll();
    }

    @PostMapping
    Family createFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }
}
