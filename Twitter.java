L1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View myView) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
         
            try {
               InputStream stream = getContentResolver().openInputStream(screenshotUri);
            } catch (FileNotFoundException temp) {
               // TODO Auto-generated catch block
               temp.printStackTrace();
            }
               sharingIntent.setType("Tayyab/jpeg");
               sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
         }
      });