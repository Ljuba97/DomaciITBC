//Zadatak radi za hemijske simbole sa malim slovima (npr. Al, Na, Cl ...), a i za zagrade (npr. Al(Na2Cl)3)

public static String molekul(String hemija){
        TreeMap<String, Integer> map = new TreeMap<>();
        ArrayList<String> str = new ArrayList<>();
        ArrayList<Integer> mul = new ArrayList<>();
        String res = "";
        boolean flag = false;

        for (int i = 0; i < hemija.length(); i++) {
            String s = "";
            String num = "0";
            if (hemija.charAt(i) == '(') {
                flag = true;
                continue;
            }
            else if (hemija.charAt(i) == ')') {
                flag = false;
                i++;
            }

            if (Character.isUpperCase(hemija.charAt(i))) {
                for (int j = i; j < hemija.length(); j++) {
                    if (j == i || Character.isLowerCase(hemija.charAt(j)))
                        s = s.concat(String.valueOf(hemija.charAt(j)));
                    else if (Character.isDigit(hemija.charAt(j))) {
                        num = String.valueOf(hemija.charAt(j));
                        if ((j + 1) < hemija.length() && Character.isDigit(hemija.charAt(j + 1))) {
                            j++;
                            num = num.concat(String.valueOf(hemija.charAt(j)));
                        }
                        i = j;
                        break;
                    }
                    else if (Integer.parseInt(num) == 0) {
                        num = "1";
                        break;
                    }
                    else {
                        i = j - 1;
                        break;
                    }
                }
            }
            if (flag)
                str.add(s);
            else if (hemija.charAt(i - 1) == ')') {
                str.add(String.valueOf(hemija.charAt(i)));
                mul.add(Integer.parseInt(String.valueOf(hemija.charAt(i))));
            }
            if (!s.equals(""))
                map.put(s, Integer.parseInt(num));
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            for (int i = 0, j = 0; i < str.size(); i++) {
                if (Character.isDigit(str.get(i).charAt(0)))
                    j++;
                if (e.getKey().equals(str.get(i)))
                    map.put(e.getKey(), e.getValue() * mul.get(j));
            }
        }

        for (Map.Entry<String, Integer> e : map.entrySet())
            res = res.concat(e.getKey()).concat(String.valueOf(e.getValue()));

        return res;
    }
