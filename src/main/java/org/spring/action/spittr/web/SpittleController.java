package org.spring.action.spittr.web;

import java.util.List;

import org.spring.action.spitter.Spittle;
import org.spring.action.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value = "/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    private SpittleRepository spittleRepository;

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles_view";
//    }

    /*
     * taking query parameters
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    /*
     * taking inpt via path parameters
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam(value = "spittle_id") long spittleId, Model model) {
        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }

    /*
     * path variables
     * 
     * If no value attribute is given for @PathVariable, it assumes the placeholder’s name is the same as the <b>method
     * parameter name</b>. This can make the code a little cleaner by not duplicating the placeholder name any more than
     * necessary. But be cautioned: if you decide to rename the parameter, you must also change the placeholder name to
     * match.
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable long spittleId, Model model) {
        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
