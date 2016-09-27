package id.zainalfahrudin.orbit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.zainalfahrudin.orbit.R;
import id.zainalfahrudin.orbit.adapter.CustomAdapter;
import id.zainalfahrudin.orbit.model.DataModel;

/**
 * Wrote by :
 * Zainal Fahrudin
 * fnzainal@gmail.com
 * on 22/09/16 15:41.
 */

public class BelajarListView extends AppCompatActivity{

    public static final String TITLE_OS = "os";
    public static final String DESC = "desk";
    public static final String ICON = "ico";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_view);

        final ListView listView = (ListView) findViewById(R.id.lvData);


        /*final String[] stringsArray = new String[] {
                "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, stringsArray);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), stringsArray[position],
//                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Intent.ACTION_SHUTDOWN));

            }
        });*/

        final List<DataModel> data = new ArrayList<>();

        data.add(new DataModel("Android", "Android is a mobile operating system developed by Google, based on the Linux kernel and designed primarily for touchscreen mobile devices such as smartphones and tablets. Android's user interface is mainly based on direct manipulation, using touch gestures that loosely correspond to real-world actions, such as swiping, tapping and pinching, to manipulate on-screen objects, along with a virtual keyboard for text input. In addition to touchscreen devices, Google has further developed Android TV for televisions, Android Auto for cars, and Android Wear for wrist watches, each with a specialized user interface. Variants of Android are also used on notebooks, game consoles, digital cameras, and other electronics.",
                R.drawable.android));
        data.add(new DataModel("Arch", "Arch Linux (or Arch /ˈɑːrtʃ/)[3] is a Linux distribution for computers based on IA-32 and x86-64 architectures.[4][b][c] It is composed predominantly of free and open-source software,[5] and supports community involvement.[6] The design approach of the development team follows the KISS principle (\"keep it simple, stupid\") as the general guideline, and focuses on elegance, code correctness, minimalism and simplicity, and expects the user to be willing to make some effort to understand the system's operation.[7] A package manager written specifically for Arch Linux, pacman, is used to install, remove and update software packages."
                ,R.drawable.arch));
        data.add(new DataModel("Debian", "Debian (/ˈdɛbiən/)[2] is a Unix-like computer operating system that is composed entirely of free software, most of which is under the GNU General Public License, and packaged by a group of individuals called the Debian Project. Three main branches are offered: stable (jessie), testing (stretch), and unstable (sid). The Debian stable Linux distribution is one of the most popular for personal computers and network servers, and has been used as a base for several other distributions. The Debian testing and unstable branches are rolling release and eventually become the stable distribution after development and testing. Packages are first uploaded to unstable, from which they migrate to testing. When testing is mature enough it becomes stable.[3]",
                R.drawable.debian));
        data.add(new DataModel("Fedora", "Fedora /fᵻˈdɒr.ə/ (formerly Fedora Core) is an operating system based on the Linux kernel, developed by the community-supported Fedora Project and sponsored by Red Hat. Fedora contains software distributed under a free and open-source license and aims to be on the leading edge of such technologies.[5][6]",
                R.drawable.fedora));
        data.add(new DataModel("Kali", "Kali Linux is a Debian-derived Linux distribution designed for digital forensics and penetration testing. It is maintained and funded by Offensive Security Ltd. Mati Aharoni, Devon Kearns and Raphaël Hertzog are the core developers.",
                R.drawable.kali));
        data.add(new DataModel("Mint", "Linux Mint is a community-driven Linux distribution based on Debian and Ubuntu that strives to be a \"modern, elegant and comfortable operating system which is both powerful and easy to use.\"[5] Linux Mint provides full out-of-the-box multimedia support by including some proprietary software and comes bundled with a variety of free and open-source applications;[6][7] however, with the release of v18 \"Sarah\" some previously included proprietary software such as multimedia codecs was no longer included by default. Its motto is \"from freedom came elegance.\"",
                R.drawable.mint));
        data.add(new DataModel("Redhat", "Red Hat Linux, assembled by the company Red Hat, was a widely used Linux distribution until its discontinuation in 2004.[1] Early releases of Red Hat Linux were called Red Hat Commercial Linux; Red Hat first published the software on November 3, 1994.[2] It was the first Linux distribution to use the RPM Package Manager as its packaging format, and over time has served as the starting point for several other distributions, such as Mandriva Linux and Yellow Dog Linux. In 2003, Red Hat discontinued the Red Hat Linux line in favor of Red Hat Enterprise Linux (RHEL) for enterprise environments. Fedora, developed by the community-supported Fedora Project and sponsored by Red Hat, is a free-of-cost alternative intended for home use. Red Hat Linux 9, the final release, hit its official end-of-life on April 30, 2004, although updates were published for it through 2006 by the Fedora Legacy project until that shut down in early 2007.[3]",
                R.drawable.redhat));
        data.add(new DataModel("Ubuntu", "Ubuntu (/ʊˈbuːntʊ/ uu-boon-tuu)[11] is a Debian-based Linux operating system and distribution for personal computers, smartphones and network servers. It uses Unity as its default user interface. It is based on free software and named after the Southern African philosophy of ubuntu (literally, 'human-ness'), which Canonical Ltd suggests can be loosely translated as \"humanity to others\" or \"I am what I am because of who we all are\".[12] Ubuntu is the most popular operating systems running in hosted environments, so–called \"clouds\",[13] as it is the most popular server Linux distribution. Development of Ubuntu is led by UK-based Canonical Ltd,[14] a company of South African entrepreneur Mark Shuttleworth. Canonical generates revenue through the sale of technical support and other services related to Ubuntu.[15][16] The Ubuntu project is publicly committed to the principles of open-source software development; people are encouraged to use free software, study how it works, improve upon it, and distribute it.",
                R.drawable.ubuntu));
        data.add(new DataModel("Windows", "Microsoft Windows (or simply Windows) is a metafamily of graphical operating systems developed, marketed, and sold by Microsoft. It consists of several families of operating systems, each of which cater to a certain sector of the computing industry with the OS typically associated with IBM PC compatible architecture. Active Windows families include Windows NT, Windows Embedded and Windows Phone; these may encompass subfamilies, e.g. Windows Embedded Compact (Windows CE) or Windows Server. Defunct Windows families include Windows 9x; Windows 10 Mobile is an active product, unrelated to the defunct family Windows Mobile.",
                R.drawable.windows));

        CustomAdapter adapter = new CustomAdapter(this, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent fulan = new Intent(BelajarListView.this, FirstActivity.class);
                fulan.putExtra(TITLE_OS,data.get(position).getNama_os());
                fulan.putExtra(DESC,data.get(position).getDeskripsi());
                fulan.putExtra(ICON, data.get(position).getIcon());
                startActivity(fulan);
            }
        });
    }
}
